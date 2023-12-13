package mx.gob.tecdmx.tablerofirmas.api.login;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.gob.tecdmx.tablerofirmas.Constants;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleado;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstEmpleadoRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgUsuariosRepository;

@Service
public class ServiceLogin {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private SegOrgUsuariosRepository segOrgUsuariosRepository;
	
	@Autowired
	InstEmpleadoRepository instEmpleadoRepository;

	public DTOResponseLogin login(DTOPayloadLogin payload, HttpServletResponse response) {
		Optional<SegOrgUsuarios> credentials = null;
		credentials = segOrgUsuariosRepository.findBysEmail(payload.getEmail());
		Optional<InstEmpleado> empleado = instEmpleadoRepository.findByIdUsuario(credentials.get());
		
		DTOResponseLogin responseDto = new DTOResponseLogin();
		if (credentials.isPresent()) {
			boolean coincide = bCryptPasswordEncoder.matches(payload.getPassword(),
					credentials.get().getsContrasenia());
			if (coincide) {
				String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(Constants.ISSUER_INFO)
						.setSubject(payload.getEmail())
						.setExpiration(new Date(System.currentTimeMillis() + Constants.TOKEN_EXPIRATION_TIME))
						.signWith(SignatureAlgorithm.HS512, Constants.SUPER_SECRET_KEY).compact();
				response.addHeader("email", credentials.get().getsEmail());
				response.addHeader("nombre", credentials.get().getsUsuario());
				response.addHeader("idEmpleado", empleado.get().getId()+"");
				response.addHeader(Constants.HEADER_AUTHORIZACION_KEY, Constants.TOKEN_BEARER_PREFIX + " " + token);
				responseDto.setStatus("success");
				responseDto.setMessage("Autenticación exitosa");
				responseDto.setToken(token);
			} else {
				responseDto.setStatus("failed");
				responseDto.setMessage("Autenticación fallida");
			}
		} else {
			credentials = segOrgUsuariosRepository.findBysUsuario(payload.getEmail());
			if (credentials.isPresent()) {
				boolean coincide = bCryptPasswordEncoder.matches(payload.getPassword(),
						credentials.get().getsContrasenia());
				if (coincide) {
					String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(Constants.ISSUER_INFO)
							.setSubject(payload.getEmail())
							.setExpiration(new Date(System.currentTimeMillis() + Constants.TOKEN_EXPIRATION_TIME))
							.signWith(SignatureAlgorithm.HS512, Constants.SUPER_SECRET_KEY).compact();
					response.addHeader("email", credentials.get().getsEmail());
					response.addHeader("nombre", credentials.get().getsUsuario());
					response.addHeader("idEmpleado", empleado.get().getId()+"");
					response.addHeader(Constants.HEADER_AUTHORIZACION_KEY, Constants.TOKEN_BEARER_PREFIX + " " + token);
					responseDto.setStatus("success");
					responseDto.setMessage("Autenticación exitosa");
					responseDto.setToken(token);
				} else {
					responseDto.setStatus("failed");
					responseDto.setMessage("Autenticación fallida");
				}
			} else {
				responseDto.setStatus("failed");
				responseDto.setMessage("El usuario o correo electrónico es incorrecto");
			}

		}

		return responseDto;
	}

	public DTOResponseLogin updatePassword(DTOPayloadLogin payload) {
		DTOResponseLogin responseDto = new DTOResponseLogin();
		Optional<SegOrgUsuarios> credentials = segOrgUsuariosRepository.findBysEmail(payload.getEmail());
		if (credentials.isPresent()) {
			credentials.get().setsContrasenia(bCryptPasswordEncoder.encode(payload.getPassword()));
			segOrgUsuariosRepository.save(credentials.get());
			responseDto.setStatus("La contraseña se ha actualizado satisfactoriamente");
		} else {
			responseDto.setStatus("El usuario ingresado no se encuentra registrado");
		}
		return responseDto;
	}

	public String encryptPassword(String password) {
		String newPassword = bCryptPasswordEncoder.encode(password);
		return newPassword;
	}

}
