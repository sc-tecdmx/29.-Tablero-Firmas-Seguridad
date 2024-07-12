package mx.gob.tecdmx.tablerofirmas.api.login;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.gob.tecdmx.tablerofirmas.Constants;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleado;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgLogSesion;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstEmpleadoRepository;
import mx.gob.tecdmx.tablerofirmas.repository.pki.PkiUsuariosCertRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgLogSesionRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgUsuariosRepository;
import mx.gob.tecdmx.tablerofirmas.utils.VOUsuario;

@Service
public class ServiceLogin {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private SegOrgUsuariosRepository segOrgUsuariosRepository;
	
	@Autowired
	SegOrgLogSesionRepository segOrgLogSesionRepository;

	@Autowired
	InstEmpleadoRepository instEmpleadoRepository;

	@Autowired
	PkiUsuariosCertRepository pkiUsuariosCertRepository;

	public DTOResponseLogin login(DTOPayloadLogin payload, HttpServletResponse response) {
		DTOResponseLogin responseDto = new DTOResponseLogin();
		
		Optional<SegOrgUsuarios> credentials = null;
		credentials = segOrgUsuariosRepository.findBysEmail(payload.getEmail());
		
		if (credentials.isPresent()) {
			
			Optional<InstEmpleado> empleado = instEmpleadoRepository.findByIdUsuario(credentials.get());
			
			if(!empleado.get().isActivo()) {
				responseDto.setStatus("failed");
				responseDto.setMessage("Esta cuenta ya no se encuentra activa");
				return responseDto;
			}
			//almacena el Log de la sesión
			SegOrgLogSesion logSesión = new SegOrgLogSesion();
			
			logSesión.setN_id_usuario(credentials.get());
			logSesión.setD_fecha_inicio(new Date());
			
			SegOrgLogSesion lastSesionGuardada = null;
			Optional<SegOrgLogSesion> lastSesionExist = segOrgLogSesionRepository.findTopByOrderByIdDesc();
			
			if(lastSesionExist.isPresent()) {
				logSesión.setChain_n_session_id(lastSesionExist.get());
				lastSesionGuardada = segOrgLogSesionRepository.save(logSesión);
				
			}else {
				lastSesionGuardada = segOrgLogSesionRepository.save(logSesión);
				logSesión.setChain_n_session_id(lastSesionGuardada);
				lastSesionGuardada = segOrgLogSesionRepository.save(logSesión);
				
			}
			
			boolean coincide = bCryptPasswordEncoder.matches(payload.getPassword(),
					credentials.get().getsContrasenia());
			if (coincide) {
				String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(Constants.ISSUER_INFO)
						.setSubject(credentials.get().getsEmail())
						.setId(lastSesionGuardada.getId()+"")
						.setExpiration(new Date(System.currentTimeMillis() + Constants.TOKEN_EXPIRATION_TIME))
						.signWith(SignatureAlgorithm.HS512, Constants.SUPER_SECRET_KEY).compact();
				response.addHeader("email", credentials.get().getsEmail());
				response.addHeader("nombre", credentials.get().getsUsuario());
				response.addHeader("idEmpleado", empleado.get().getId() + "");
				response.addHeader(Constants.HEADER_AUTHORIZACION_KEY, Constants.TOKEN_BEARER_PREFIX + " " + token);
				
				
				responseDto.setStatus("success");
				responseDto.setMessage("Autenticación exitosa");
				responseDto.setToken(token);
				responseDto.setData(empleado.get().getId());
				
			} else {
				responseDto.setStatus("failed");
				responseDto.setMessage("Autenticación fallida");
			}
		} else {
			credentials = segOrgUsuariosRepository.findBysUsuario(payload.getEmail());
			if (credentials.isPresent()) {
				
				Optional<InstEmpleado> empleado = instEmpleadoRepository.findByIdUsuario(credentials.get());
				
				if(!empleado.get().isActivo()) {
					responseDto.setStatus("failed");
					responseDto.setMessage("Esta cuenta ya no se encuentra activa");
					return responseDto;
				}
				
				//almacena el Log de la sesión
				SegOrgLogSesion logSesión = new SegOrgLogSesion();
				
				logSesión.setN_id_usuario(credentials.get());
				logSesión.setD_fecha_inicio(new Date());
				
				SegOrgLogSesion lastSesionGuardada = null;
				Optional<SegOrgLogSesion> lastSesionExist = segOrgLogSesionRepository.findTopByOrderByIdDesc();
				
				if(lastSesionExist.isPresent()) {
					logSesión.setChain_n_session_id(lastSesionExist.get());
					lastSesionGuardada = segOrgLogSesionRepository.save(logSesión);
					
				}else {
					lastSesionGuardada = segOrgLogSesionRepository.save(logSesión);
					logSesión.setChain_n_session_id(lastSesionGuardada);
					lastSesionGuardada = segOrgLogSesionRepository.save(logSesión);
					
				}
				
				boolean coincide = bCryptPasswordEncoder.matches(payload.getPassword(),
						credentials.get().getsContrasenia());
				if (coincide) {
					String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(Constants.ISSUER_INFO)
							.setSubject(credentials.get().getsEmail())
							.setId(lastSesionGuardada.getId()+"")
							.setExpiration(new Date(System.currentTimeMillis() + Constants.TOKEN_EXPIRATION_TIME))
							.signWith(SignatureAlgorithm.HS512, Constants.SUPER_SECRET_KEY).compact();
					response.addHeader("email", credentials.get().getsEmail());
					response.addHeader("nombre", credentials.get().getsUsuario());
					response.addHeader("idEmpleado", empleado.get().getId() + "");
					response.addHeader(Constants.HEADER_AUTHORIZACION_KEY, Constants.TOKEN_BEARER_PREFIX + " " + token);
				
					responseDto.setStatus("success");
					responseDto.setMessage("Autenticación exitosa");
					responseDto.setToken(token);
					responseDto.setData(empleado.get().getId());
					
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
	
	public boolean logout(Authentication auth) {
		VOUsuario usuarioVO = (VOUsuario) auth.getDetails();
		Optional<SegOrgLogSesion> sesionExist =segOrgLogSesionRepository.findById(Integer.parseInt(usuarioVO.getIdSession()));
		if(sesionExist.isPresent()) {
			
			 long tiempoTerminacion = System.currentTimeMillis();
			//almacena el Log de la sesión
			sesionExist.get().setD_fecha_fin(new Date());
			sesionExist.get().setN_end_sesion(tiempoTerminacion);
			segOrgLogSesionRepository.save(sesionExist.get());
			
			return true;
		}
		
		
		return false;
		
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

	public DTOResponseLogin loginEscritorio(DTOPayLoadLoginEscritorio payload, HttpServletResponse response) {

		DTOResponseLogin responseDto = new DTOResponseLogin();
		
		Optional<SegOrgUsuarios> credentials = null;
		credentials = segOrgUsuariosRepository.findBysEmail(payload.getEmail());
		Optional<InstEmpleado> empleado = instEmpleadoRepository.findByIdUsuario(credentials.get());
		
		if(!empleado.get().isActivo()) {
			responseDto.setStatus("failed");
			responseDto.setMessage("No cuenta con permisos para firmar por que su cuenta ya no se encuentra activa");
			return responseDto;
		}
		
		//almacena el Log de la sesión
		SegOrgLogSesion logSesión = new SegOrgLogSesion();
		
		logSesión.setN_id_usuario(credentials.get());
		logSesión.setD_fecha_inicio(new Date());
		
		SegOrgLogSesion lastSesionGuardada = null;
		Optional<SegOrgLogSesion> lastSesionExist = segOrgLogSesionRepository.findTopByOrderByIdDesc();
		
		if(lastSesionExist.isPresent()) {
			logSesión.setChain_n_session_id(lastSesionExist.get());
			lastSesionGuardada = segOrgLogSesionRepository.save(logSesión);
			
		}else {
			lastSesionGuardada = segOrgLogSesionRepository.save(logSesión);
			logSesión.setChain_n_session_id(lastSesionGuardada);
			lastSesionGuardada = segOrgLogSesionRepository.save(logSesión);
			
		}

		//Optional<PkiUsuariosCert> usuCert = pkiUsuariosCertRepository.findByX509SerialNumber(payload.getNoSerie());
		String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(Constants.ISSUER_INFO)
				.setSubject(payload.getEmail())
				.setId(lastSesionGuardada.getId()+"")
				.setExpiration(new Date(System.currentTimeMillis() + Constants.TOKEN_EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, Constants.SUPER_SECRET_KEY).compact();
		response.addHeader("email", payload.getEmail());
		response.addHeader("nombre", payload.getNombre());
		response.addHeader("idEmpleado", payload.getIdEmpleado());
		response.addHeader(Constants.HEADER_AUTHORIZACION_KEY, Constants.TOKEN_BEARER_PREFIX + " " + token);
		responseDto.setStatus("success");
		responseDto.setMessage("Autenticación exitosa");
		responseDto.setToken(token);
		return responseDto;
	}

	public String encryptPassword(String password) {
		String newPassword = bCryptPasswordEncoder.encode(password);
		return newPassword;
	}

}
