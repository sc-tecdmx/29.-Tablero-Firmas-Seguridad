/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.tecdmx.tablerofirmas.api.usuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.gob.tecdmx.tablerofirmas.api.empleados.DTOUsuario;
import mx.gob.tecdmx.tablerofirmas.api.login.ServiceLogin;
import mx.gob.tecdmx.tablerofirmas.api.menu.ServiceMenu;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstCatAreas;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstCatPuestos;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleado;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleadoPuestoArea;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstLogEmpleado;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegCatEstadoUsuario;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegLogUsuario;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgLogSesion;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgRoles;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgRolesUsuarios;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarioEstadoUsuario;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstCatAreasRepository;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstCatPuestosRepository;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstEmpleadoPuestoAreaRepository;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstEmpleadoRepository;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstLogEmpleadoRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegCatEstadoUsuarioRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegLogUsuarioRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgLogSesionRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgRolesRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgRolesUsuariosRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgUsuarioEstadoUsuarioRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgUsuariosRepository;
import mx.gob.tecdmx.tablerofirmas.utils.DTOResponse;
import mx.gob.tecdmx.tablerofirmas.utils.DTOUserInfo;
import mx.gob.tecdmx.tablerofirmas.utils.PerfilDTO;
import mx.gob.tecdmx.tablerofirmas.utils.ResponseBodyMenu;
import mx.gob.tecdmx.tablerofirmas.utils.VOUsuario;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	ServiceLogin serviceLogin;

	@Autowired
	private SegOrgUsuariosRepository segOrgUsuariosRepository;
	
	@Autowired
	SegLogUsuarioRepository segLogUsuarioRepository;

	@Autowired
	private InstEmpleadoRepository instEmpleadoRepository;
	
	@Autowired
	InstLogEmpleadoRepository instLogEmpleadoRepository;

	@Autowired
	InstCatAreasRepository instAreasRepository;

	@Autowired
	InstEmpleadoPuestoAreaRepository empleadoPuestoAreaRepository;

	@Autowired
	SegCatEstadoUsuarioRepository segCatEstadoUsuarioRepository;

	@Autowired
	SegOrgUsuarioEstadoUsuarioRepository segOrgUsuarioEstadoUsuarioRepository;

	@Autowired
	SegOrgRolesRepository segOrgRolesRepository;
	
	@Autowired
	SegOrgLogSesionRepository segOrgLogSesionRepository;

	@Autowired
	SegOrgRolesUsuariosRepository segOrgRolesUsuariosRepository;

	@Autowired
	private ServiceMenu serviceMenu;
	
	@Autowired
	private InstCatPuestosRepository instCatPuestosRepository;

	@Override
	public UserDetails loadUserByUsername(String emailAndIdSession) throws UsernameNotFoundException {
		String email = emailAndIdSession.split(":")[0];
		String idSession = emailAndIdSession.split(":")[1];
		Optional<SegOrgUsuarios> credentials = segOrgUsuariosRepository.findBysEmail(email);
		if (!credentials.isPresent()) {
			credentials = segOrgUsuariosRepository.findBysUsuario(email);
			if (!credentials.isPresent()) {
//				throw new UsernameNotFoundException(email);
				return null;
			}
		}

		SegOrgUsuarios user = credentials.get();

		List<GrantedAuthority> roles = new ArrayList();
		// Agregar aqui el rol o roles para esta aplicación.
		// roles.add(new SimpleGrantedAuthority("ADMIN"));
		UserDetails userDetail = new VOUsuario(user.getsUsuario(), user.getsContrasenia(), roles, user.getnIdUsuario(),
				user.getsEmail(), idSession);

		return userDetail;
	}

	public DTOResponse userInfo(Authentication auth, DTOResponse response) {
		VOUsuario usuarioVO = (VOUsuario) auth.getDetails();
		Optional<SegOrgUsuarios> usuario = segOrgUsuariosRepository.findBysEmail(usuarioVO.getEmail());
		if (usuario.isPresent()) {
			DTOUserInfo userInfo = new DTOUserInfo();
			userInfo.setUsuario(usuario.get().getsUsuario());
			userInfo.setEmail(usuario.get().getsEmail());
			userInfo.setIdUsuario(usuario.get().getnIdUsuario());

			Optional<InstEmpleado> empleado = instEmpleadoRepository.findByIdUsuario(usuario.get());
			if (empleado.isPresent()) {
				userInfo.setIdEmpleado(empleado.get().getId());
				userInfo.setNombre(empleado.get().getNombre());
				userInfo.setApellido1(empleado.get().getApellido1());
				userInfo.setApellido2(empleado.get().getApellido2());
				userInfo.setIdSession(usuarioVO.getIdSession());
			}
			
			List<PerfilDTO> perfiles = serviceMenu.getMenu(auth);
			userInfo.setPerfiles(perfiles);
			response.setData(userInfo);
			response.setMessage("EL token es válido");
			response.setStatus("Success");
			return response;
		}
		response.setMessage("EL token es inválido");
		response.setStatus("Fail");
		return response;
	}

	public DTOResponse createUser(DTOUsuario user, DTOResponse response, Authentication auth) {
		VOUsuario usuarioVO = (VOUsuario) auth.getDetails();
		SegOrgUsuarios usuarioStored = null;
		Optional<InstEmpleado> empleado = null;
		List<InstEmpleadoPuestoArea> empleadoPuestoAreaList = null;
		if (user != null) {
			// verifica que el correo institucional proporcionado corresponda a un empleado
			// en el sistema
			empleado = instEmpleadoRepository.findByEmailInst(user.getEmail());
			if (empleado.isPresent()) {
				// verifica que sea un empleado activo
				if (!empleado.get().isActivo()) {
					response.setMessage("No es posible crear una cuenta ya que no cuentas con permisos");
					response.setStatus("Fail");
					response.setData(null);
					return response;
				}
	
				// verifica que el correo a utilizar no se encuentre en la bd de usuarios
				Optional<SegOrgUsuarios> usuarioEmail = segOrgUsuariosRepository.findBysEmail(user.getEmail());
				if (usuarioEmail.isPresent()) {
					response.setMessage("El correo utilizado corresponde a otra cuenta de usuario");
					response.setStatus("Fail");
					response.setData(null);
					return response;

				} else {
					// verifica que el correo personal del empleado entrante no se encuentre en la
					// bd de usuarios
					Optional<SegOrgUsuarios> usuarioEmailPer = segOrgUsuariosRepository
							.findBysEmail(empleado.get().getEmailPers());
					if (usuarioEmailPer.isPresent()) {
						response.setMessage("Ya tienes activa otra cuenta de usuario");
						response.setStatus("Fail");
						response.setData(null);
						return response;
					}
				}
				// seteo de informacion para almacenar en bd tabla usuarios
				SegOrgUsuarios usuario = new SegOrgUsuarios();

				Optional<SegCatEstadoUsuario> estadoCuenta = segCatEstadoUsuarioRepository.findByDescripcion("Activa");

				usuario.setsUsuario(user.getUsuario());
				usuario.setsContrasenia(serviceLogin.encryptPassword(user.getContrasenia()));
				usuario.setsDescUsuario(null);
				usuario.setsEmail(user.getEmail());
				usuario.setnIdEstadoUsuario(estadoCuenta.get());
				usuario.setsToken(null);
				usuarioStored = segOrgUsuariosRepository.save(usuario);

				// tabla usuario-estadoUsuario
				SegOrgUsuarioEstadoUsuario bitacoraEstatusUsuario = new SegOrgUsuarioEstadoUsuario();
//				Optional<SegOrgLogSesion> sesionExist =segOrgLogSesionRepository.findById(Integer.parseInt(usuarioVO.getIdSession()));
				bitacoraEstatusUsuario.setIdUsuario(usuarioStored);
				bitacoraEstatusUsuario.setIdEstadoUsuario(estadoCuenta.get());
				bitacoraEstatusUsuario.setFingerprintDispositivo(null);
				bitacoraEstatusUsuario.setFechaStatus(new Date());
//				bitacoraEstatusUsuario.setSessionId(sesionExist.get());
				segOrgUsuarioEstadoUsuarioRepository.save(bitacoraEstatusUsuario);

				empleadoPuestoAreaList = empleadoPuestoAreaRepository.findByIdNumEmpleado(empleado.get());
				Optional<SegOrgRoles> rol = segOrgRolesRepository.findByEtiquetaRol("SA");
				for(InstEmpleadoPuestoArea empleadoPuestoArea: empleadoPuestoAreaList) {
					Optional<InstCatAreas> unidadAdscId = instAreasRepository.findById(empleadoPuestoArea.getIdCatArea().getId());
					
					// tabla de roles-usuario
					SegOrgRolesUsuarios rolesUsuarios = new SegOrgRolesUsuarios();
					rolesUsuarios.setIdRol(rol.get());
					rolesUsuarios.setIdUsuario(usuarioStored);
					rolesUsuarios.setIdEmpleadoPuestoArea(empleadoPuestoArea);
					rolesUsuarios.setnIdUAdscripcion(unidadAdscId.get().getIdUnAdscripcion());
//					rolesUsuarios.setnSessionId(sesionExist.get());

					segOrgRolesUsuariosRepository.save(rolesUsuarios);
				}
			
				// RELACIONA AL EMPLEADO CON EL USUARIO
				empleado.get().setIdUsuario(usuarioStored);
				instEmpleadoRepository.save(empleado.get());
				
				//almacena el Log del empleado
//				InstLogEmpleado logEmpleado = new InstLogEmpleado();
//				Optional<InstEmpleado> empleadoLog = instEmpleadoRepository.findByEmailInst(usuarioVO.getEmail());
//				logEmpleado.setIdNumEmpleado(empleadoLog.get());
////				logEmpleado.setSessionId(sesionExist.get());
//				logEmpleado.setBitacora("actualizar");
//				instLogEmpleadoRepository.save(logEmpleado);
				
				//almacena el Log del usuario
//				SegLogUsuario userLog = new SegLogUsuario();
//				userLog.setN_id_usuario(usuarioStored);
////				userLog.setN_session_id(sesionExist.get().getId());
//				userLog.setD_sistema(new Date());
//				userLog.setBitacora("creado");
//				segLogUsuarioRepository.save(userLog);
				
				response.setData(usuarioStored);
				response.setMessage("El usuario se han creado correctamente");
				response.setStatus("Success");
				return response;

			} else {
				// verifica que el correo personal proporcionado corresponda a un empleado en el
				// sistema
				empleado = instEmpleadoRepository.findByEmailPers(user.getEmail());

				if (empleado.isPresent()) {
					if (!empleado.get().isActivo()) {
						response.setMessage("No es posible crear una cuenta ya que no cuentas con permisos");
						response.setStatus("Fail");
						response.setData(null);
						return response;
					}
					
					// verifica que el correo a utilizar no se encuentre en la bd de usuarios
					Optional<SegOrgUsuarios> usuarioEmail = segOrgUsuariosRepository.findBysEmail(user.getEmail());
					if (usuarioEmail.isPresent()) {
						response.setMessage("El correo utilizado corresponde a otra cuenta de usuario");
						response.setStatus("Fail");
						response.setData(null);
						return response;

					} else {
						// verifica que el correo personal del empleado entrante no se encuentre en la
						// bd de usuarios
						Optional<SegOrgUsuarios> usuarioEmailIns = segOrgUsuariosRepository
								.findBysEmail(empleado.get().getEmailInst());
						if (usuarioEmailIns.isPresent()) {
							response.setMessage("Ya tienes activa otra cuenta de usuario");
							response.setStatus("Fail");
							response.setData(null);
							return response;
						}
					}
					// seteo de informacion para almacenar en bd tabla usuarios
					SegOrgUsuarios usuario = new SegOrgUsuarios();

					Optional<SegCatEstadoUsuario> estadoCuenta = segCatEstadoUsuarioRepository
							.findByDescripcion("Activa");

					usuario.setsUsuario(user.getUsuario());
					usuario.setsContrasenia(serviceLogin.encryptPassword(user.getContrasenia()));
					usuario.setsDescUsuario(null);
					usuario.setsEmail(user.getEmail());
					usuario.setnIdEstadoUsuario(estadoCuenta.get());
					usuario.setsToken(null);
					usuarioStored = segOrgUsuariosRepository.save(usuario);

					// tabla usuario-estadoUsuario
					SegOrgUsuarioEstadoUsuario bitacoraEstatusUsuario = new SegOrgUsuarioEstadoUsuario();
//					Optional<SegOrgLogSesion> sesionExist =segOrgLogSesionRepository.findById(Integer.parseInt(usuarioVO.getIdSession()));
					
					bitacoraEstatusUsuario.setIdUsuario(usuarioStored);
					bitacoraEstatusUsuario.setIdEstadoUsuario(estadoCuenta.get());
					bitacoraEstatusUsuario.setFingerprintDispositivo(null);
					bitacoraEstatusUsuario.setFechaStatus(new Date());
//					bitacoraEstatusUsuario.setSessionId(sesionExist.get());
					segOrgUsuarioEstadoUsuarioRepository.save(bitacoraEstatusUsuario);

					empleadoPuestoAreaList = empleadoPuestoAreaRepository.findByIdNumEmpleado(empleado.get());
					Optional<SegOrgRoles> rol = segOrgRolesRepository.findByEtiquetaRol("OP");
					for(InstEmpleadoPuestoArea empleadoPuestoArea: empleadoPuestoAreaList) {
						Optional<InstCatAreas> unidadAdscId = instAreasRepository.findById(empleadoPuestoArea.getIdCatArea().getId());
						
						// tabla de roles-usuario
						SegOrgRolesUsuarios rolesUsuarios = new SegOrgRolesUsuarios();
						rolesUsuarios.setIdRol(rol.get());
						rolesUsuarios.setIdUsuario(usuarioStored);
						rolesUsuarios.setIdEmpleadoPuestoArea(empleadoPuestoArea);
						rolesUsuarios.setnIdUAdscripcion(unidadAdscId.get().getIdUnAdscripcion());
//						rolesUsuarios.setnSessionId(sesionExist.get());

						segOrgRolesUsuariosRepository.save(rolesUsuarios);
					}

					// RELACIONA AL EMPLEADO CON EL USUARIO
					empleado.get().setIdUsuario(usuarioStored);
					instEmpleadoRepository.save(empleado.get());
					
					//almacena el Log del empleado
//					InstLogEmpleado logEmpleado = new InstLogEmpleado();
//					Optional<InstEmpleado> empleadoLog = instEmpleadoRepository.findByEmailInst(usuarioVO.getEmail());
//					logEmpleado.setIdNumEmpleado(empleadoLog.get());
//					logEmpleado.setSessionId(sesionExist.get());
//					logEmpleado.setBitacora("actualizar");
//					instLogEmpleadoRepository.save(logEmpleado);

					//almacena el Log del usuario
//					SegLogUsuario userLog = new SegLogUsuario();
//					userLog.setN_id_usuario(usuarioStored);
////					userLog.setN_session_id(sesionExist.get().getId());
//					userLog.setD_sistema(new Date());
//					userLog.setBitacora("creado");
//					segLogUsuarioRepository.save(userLog);
					
					response.setData(usuarioStored);
					response.setMessage("El usuario se han creado correctamente");
					response.setStatus("Success");
					return response;

				}
			}

		}
		response.setMessage("No se pudo realizar el registro");
		response.setStatus("Fail");
		response.setData(null);
		return response;
	}

	public DTOResponse getUsuarios(DTOResponse response) {
		DTOUserInfo userInfo = null;
		List<DTOUserInfo> usuariosInfo = new ArrayList<DTOUserInfo>();
		Iterable<SegOrgUsuarios> usuarios = segOrgUsuariosRepository.findAll();
		for (SegOrgUsuarios usuario : usuarios) {
			Optional<InstEmpleado> empleado = instEmpleadoRepository.findByIdUsuario(usuario);
			userInfo = new DTOUserInfo();

			userInfo.setIdUsuario(usuario.getnIdUsuario());
			userInfo.setNombre(empleado.get().getNombre());
			userInfo.setApellido1(empleado.get().getApellido1());
			userInfo.setApellido2(empleado.get().getApellido2());
			userInfo.setIdEmpleado(empleado.get().getId());
			userInfo.setUsuario(usuario.getsUsuario());
			userInfo.setEmail(usuario.getsEmail());
			
			Optional<SegCatEstadoUsuario> idEstado = segCatEstadoUsuarioRepository.findById(usuario.getnIdEstadoUsuario().getN_id_estado_usuario());
			
			userInfo.setStatusCuenta(idEstado.get().getDescripcion());

			ResponseBodyMenu menu = new ResponseBodyMenu();
			List<PerfilDTO> perfiles = serviceMenu.getMenu(menu, usuario);
			userInfo.setPerfiles(perfiles);
			
//			userInfo.setRol(menu.getRol());
//			userInfo.setAplicacion(menu.getAplicacion());
//			menu.setMenu(null);

			usuariosInfo.add(userInfo);
		}

		response.setMessage("Información de los Usuarios");
		response.setStatus("Success");
		response.setData(usuariosInfo);
		return response;
	}

	public DTOResponse editarUser(DTOUsuario user, DTOResponse response, Authentication auth) {
		VOUsuario usuarioVO = (VOUsuario) auth.getDetails();
		Optional<SegOrgLogSesion> sesionExist =segOrgLogSesionRepository.findById(Integer.parseInt(usuarioVO.getIdSession()));
		
		Optional<SegOrgUsuarios> usuarioExist = null;
		if ((user.getCodigoRol() != null) && (user.getEstatusCuenta() != null)) {

			usuarioExist = segOrgUsuariosRepository.findBysEmail(user.getEmail());
			if (!usuarioExist.isPresent()) {
				response.setMessage("El usuario que desea Actualizar no existe");
				response.setStatus("Fail");
				return response;
			}

			Optional<SegCatEstadoUsuario> estadoCuenta = segCatEstadoUsuarioRepository
					.findByDescripcion(user.getEstatusCuenta());
			usuarioExist.get().setnIdEstadoUsuario(estadoCuenta.get());
			segOrgUsuariosRepository.save(usuarioExist.get());

			// tabla usuario-estadoUsuario
			Optional<SegOrgUsuarioEstadoUsuario> bitacoraEstatusUsuario = segOrgUsuarioEstadoUsuarioRepository
					.findByIdUsuario(usuarioExist.get());
			bitacoraEstatusUsuario.get().setIdEstadoUsuario(estadoCuenta.get());
			bitacoraEstatusUsuario.get().setFechaStatus(new Date());
			bitacoraEstatusUsuario.get().setSessionId(sesionExist.get());
			segOrgUsuarioEstadoUsuarioRepository.save(bitacoraEstatusUsuario.get());

			Optional<SegOrgRoles> rol = segOrgRolesRepository.findByEtiquetaRol(user.getCodigoRol());
			Optional<SegOrgRoles> rolAnterior = segOrgRolesRepository.findByEtiquetaRol(user.getRolAnterior());
			
			// tabla de roles-usuario
			Optional<SegOrgRolesUsuarios> rolesUsuarios = segOrgRolesUsuariosRepository.findByIdRolAndIdUsuario(rolAnterior.get(), usuarioExist.get());
			rolesUsuarios.get().setIdRol(rol.get());
			rolesUsuarios.get().setnSessionId(sesionExist.get());

			segOrgRolesUsuariosRepository.save(rolesUsuarios.get());
			
			//almacena el Log del usuario
			SegLogUsuario userLog = new SegLogUsuario();
			userLog.setN_id_usuario(usuarioExist.get());
			userLog.setN_session_id(sesionExist.get().getId());
			userLog.setD_sistema(new Date());
			userLog.setBitacora("creado");
			segLogUsuarioRepository.save(userLog);

			response.setMessage("Información actualizada con éxito");
			response.setStatus("Success");
			return response;
		}

		response.setMessage("No fué posible actualizar la información");
		response.setStatus("fail");
		return response;
		// TODO Auto-generated method stub

	}

}
