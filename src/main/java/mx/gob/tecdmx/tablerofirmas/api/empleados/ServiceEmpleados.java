package mx.gob.tecdmx.tablerofirmas.api.empleados;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstCatAreas;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstCatPuestos;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstCatSexo;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleado;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleadoPuesto;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstTitularUAdscripcion;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstUAdscripcion;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegCatEstadoUsuario;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgRoles;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgRolesUsuarios;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarioEstadoUsuario;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstCatAreasRepository;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstCatPuestosRepository;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstCatSexoRepository;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstEmpleadoPuestoRepository;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstEmpleadoRepository;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstTitularUAdscripcionRepository;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstUAdscripcionRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegCatEstadoUsuarioRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgRolesRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgRolesUsuariosRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgUsuarioEstadoUsuarioRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgUsuariosRepository;
import mx.gob.tecdmx.tablerofirmas.utils.DTOResponse;
import mx.gob.tecdmx.tablerofirmas.utils.SeguridadUtils;

@Service
public class ServiceEmpleados {

	@Autowired
	InstCatAreasRepository instCatAreasRepository;

	@Autowired
	InstCatPuestosRepository instCatPuestosRepository;

	@Autowired
	InstCatSexoRepository instCatSexoRepository;

	@Autowired
	InstEmpleadoPuestoRepository instEmpleadoPuestoRepository;

	@Autowired
	InstEmpleadoRepository instEmpleadoRepository;

	@Autowired
	InstTitularUAdscripcionRepository instTitularUAdscripcionRepository;
	
	@Autowired
	InstUAdscripcionRepository instUAdscripcionRepository;

	@Autowired
	InstUAdscripcionRepository SegOrgUsuariosRepository;

	@Autowired
	SegOrgUsuariosRepository segOrgUsuariosRepository;

	@Autowired
	SegCatEstadoUsuarioRepository segCatEstadoUsuarioRepository;

	@Autowired
	SegOrgUsuarioEstadoUsuarioRepository segOrgUsuarioEstadoUsuarioRepository;

	@Autowired
	SegOrgRolesRepository segOrgRolesRepository;

	@Autowired
	SegOrgRolesUsuariosRepository segOrgRolesUsuariosRepository;

	public DTOResponse createEmpleado(PayloadEmpleados payload, DTOResponse response) {
		SeguridadUtils utils = new SeguridadUtils();
		ResponseBodyEmpleados resp = new ResponseBodyEmpleados();

		Optional<InstCatSexo> sexo = instCatSexoRepository.findBySexo(payload.getCodigoSexo());
		if (sexo.isPresent()) {
			Optional<InstCatPuestos> puesto = instCatPuestosRepository
					.findByDescNombramiento(payload.getCodigoPuesto());
			if (puesto.isPresent()) {
				Optional<InstCatAreas> area = instCatAreasRepository.findByAbrevArea(payload.getCodigoArea());
				if (area.isPresent()) {

					SegOrgUsuarios usuarioStored = null;

					if (payload.getUsuario() != null) {

						Optional<SegCatEstadoUsuario> estadoCuenta = segCatEstadoUsuarioRepository
								.findByDescripcion(payload.getUsuario().getEstatusCuenta());
						if (estadoCuenta.isPresent()) {
							SegOrgUsuarios usuario = new SegOrgUsuarios();
							usuario.setsUsuario(payload.getUsuario().getUsuario());
							usuario.setsContrasenia(payload.getUsuario().getContrasenia());
							usuario.setsDescUsuario(null);
							usuario.setsEmail(payload.getEmailInst());
							usuario.setnIdEstadoUsuario(estadoCuenta.get());
							usuario.setsToken(null);
							usuarioStored = segOrgUsuariosRepository.save(usuario);

							SegOrgUsuarioEstadoUsuario bitacoraEstatusUsuario = new SegOrgUsuarioEstadoUsuario();
							bitacoraEstatusUsuario.setIdUsuario(usuarioStored);
							bitacoraEstatusUsuario.setIdEstadoUsuario(estadoCuenta.get());
							bitacoraEstatusUsuario.setFingerprintDispositivo(null);
							bitacoraEstatusUsuario.setFechaStatus(new Date());
							bitacoraEstatusUsuario.setSessionId(null);

							segOrgUsuarioEstadoUsuarioRepository.save(bitacoraEstatusUsuario);

							if (payload.getUsuario().getCodigoRol() != null) {
								Optional<SegOrgRoles> rol = segOrgRolesRepository
										.findByEtiquetaRol(payload.getUsuario().getCodigoRol());
								if (rol.isPresent()) {
									SegOrgRolesUsuarios rolesUsuarios = new SegOrgRolesUsuarios();
									rolesUsuarios.setnIdRol(rol.get());
									rolesUsuarios.setnIdUsuario(usuarioStored);
									rolesUsuarios.setnIdUAdscripcion(area.get().getIdUnAdscripcion());
									rolesUsuarios.setnSessionId(null);

									segOrgRolesUsuariosRepository.save(rolesUsuarios);

								}
							}

							resp.setUsuario(usuarioStored);
							response.setData(resp);

							response.setMessage("El empleado y usuario se han creado correctamente");
							response.setStatus("Success");

						} else {
							response.setMessage("El código de estado de la cuenta es incorrecto");
							response.setStatus("Fail");
							response.setData(null);
							return response;
						}
					}

					InstEmpleado empleado = new InstEmpleado();
					empleado.setId(payload.getIdNumEmpleado());
					empleado.setNombre(payload.getNombre());
					empleado.setApellido1(payload.getApellido1());
					empleado.setApellido2(payload.getApellido2());
					empleado.setIdSexo(sexo.get());
					empleado.setEmailPers(payload.getEmailPers());
					empleado.setEmailInst(payload.getEmailInst());
					empleado.setTelPers(payload.getTelPers());
					empleado.setTelInst(payload.getTelInst());
					empleado.setCurp(payload.getCurp());
					empleado.setRfc(payload.getRfc());
					empleado.setPathFotografia(payload.getPathFotografia());
					empleado.setIdUsuario(usuarioStored);
					InstEmpleado empleadoStored = instEmpleadoRepository.save(empleado);

					InstEmpleadoPuesto empleadoPuesto = new InstEmpleadoPuesto();
					empleadoPuesto.setIdNumEmpleado(empleadoStored);
					empleadoPuesto.setIdCatArea(area.get());
					empleadoPuesto.setIdPuesto(puesto.get());
					empleadoPuesto.setFechaAlta(utils.formatDate(payload.getFechaAltaEmpleado()));
					empleadoPuesto.setFechaConclusion(null);

					instEmpleadoPuestoRepository.save(empleadoPuesto);
					response.setMessage("El empleado se ha creado correctamente");
					response.setStatus("Success");

					resp.setEmpleado(empleadoStored);
					response.setData(resp);

					if (payload.isEsTitular()) {
						InstTitularUAdscripcion titular = new InstTitularUAdscripcion();
						titular.setIdUnAdscripcion(area.get().getIdUnAdscripcion());
						titular.setIdEmpleadoPuesto(empleadoPuesto);
						titular.setFechaInicio(utils.formatDate(payload.getFechainicioTitular()));
						titular.setFechaConclusion(null);

						instTitularUAdscripcionRepository.save(titular);
					}

				} else {
					response.setMessage("El código de area es incorrecto");
					response.setStatus("Fail");
				}
			} else {
				response.setMessage("El código de puesto es incorrecto");
				response.setStatus("Fail");
			}
		} else {
			response.setMessage("El código de sexo es incorrecto");
			response.setStatus("Fail");
		}
		return response;
	}

	public DTOResponse createEmpleadoV2(PayloadEmpleados payload, DTOResponse response) {
		SeguridadUtils utils = new SeguridadUtils();
		ResponseBodyEmpleados resp = new ResponseBodyEmpleados();

		Optional<InstEmpleado> empleadoExist = instEmpleadoRepository.findById(payload.getIdNumEmpleado());
		if (empleadoExist.isPresent()) {
			response.setMessage("Ya existe un registro con el número de empleado proporcionado");
			response.setStatus("Fail");
			return response;
		}
		if (payload.getEmailInst() != null) {
			Optional<InstEmpleado> empleadoExistEmail = instEmpleadoRepository.findByEmailInst(payload.getEmailInst());
			if (empleadoExistEmail.isPresent()) {
				response.setMessage("Ya existe un registro con el correo institucional proporcionado");
				response.setStatus("Fail");
				return response;
			}
		}
		if (payload.getEmailPers() != null) {
			Optional<InstEmpleado> empleadoExistEmail = instEmpleadoRepository.findByEmailPers(payload.getEmailPers());
			if (empleadoExistEmail.isPresent()) {
				response.setMessage("Ya existe un registro con el correo personal proporcionado");
				response.setStatus("Fail");
				return response;
			}
		}

		Optional<InstCatSexo> sexo = instCatSexoRepository.findBySexo(payload.getCodigoSexo());
		if (sexo.isPresent()) {
			Optional<InstCatPuestos> puesto = instCatPuestosRepository
					.findByDescNombramiento(payload.getCodigoPuesto());
			if (puesto.isPresent()) {
				Optional<InstCatAreas> area = instCatAreasRepository.findByAbrevArea(payload.getCodigoArea());
				if (area.isPresent()) {

					InstEmpleado empleado = new InstEmpleado();
					empleado.setId(payload.getIdNumEmpleado());
					empleado.setNombre(payload.getNombre());
					empleado.setApellido1(payload.getApellido1());
					empleado.setApellido2(payload.getApellido2());
					empleado.setIdSexo(sexo.get());
					empleado.setEmailPers(payload.getEmailPers());
					empleado.setEmailInst(payload.getEmailInst());
					empleado.setTelPers(payload.getTelPers());
					empleado.setTelInst(payload.getTelInst());
					empleado.setCurp(payload.getCurp());
					empleado.setRfc(payload.getRfc());
					empleado.setPathFotografia(payload.getPathFotografia());
					InstEmpleado empleadoStored = instEmpleadoRepository.save(empleado);

					InstEmpleadoPuesto empleadoPuesto = new InstEmpleadoPuesto();
					empleadoPuesto.setIdNumEmpleado(empleadoStored);
					empleadoPuesto.setIdCatArea(area.get());
					empleadoPuesto.setIdPuesto(puesto.get());
					empleadoPuesto.setFechaAlta(utils.formatDate(payload.getFechaAltaEmpleado()));
					empleadoPuesto.setFechaConclusion(null);

					instEmpleadoPuestoRepository.save(empleadoPuesto);
					response.setMessage("El empleado se ha creado correctamente");
					response.setStatus("Success");

					resp.setEmpleado(empleadoStored);
					response.setData(resp);

					if (payload.isEsTitular()) {
						InstTitularUAdscripcion titular = new InstTitularUAdscripcion();
						titular.setIdUnAdscripcion(area.get().getIdUnAdscripcion());
						titular.setIdEmpleadoPuesto(empleadoPuesto);
						titular.setFechaInicio(utils.formatDate(payload.getFechainicioTitular()));
						titular.setFechaConclusion(null);

						instTitularUAdscripcionRepository.save(titular);
					}

				} else {
					response.setMessage("El código de area es incorrecto");
					response.setStatus("Fail");
				}
			} else {
				response.setMessage("El código de puesto es incorrecto");
				response.setStatus("Fail");
			}
		} else {
			response.setMessage("El código de sexo es incorrecto");
			response.setStatus("Fail");
		}
		return response;
	}

	public DTOResponse consultarEmpleado(int idEmpleado, DTOResponse response) {
		DTOResponseEmpleado resp = new DTOResponseEmpleado();

		Optional<InstEmpleado> empleadoExist = instEmpleadoRepository.findById(idEmpleado);
		
		if (!empleadoExist.isPresent()) {
			response.setMessage("El usuario no existe");
			response.setStatus("Fail");

		} else {

			Optional<InstEmpleadoPuesto> empleadoPuesto = instEmpleadoPuestoRepository.findByIdNumEmpleado(empleadoExist.get());
			if (!empleadoPuesto.isPresent()) {
				response.setMessage("No se pudo obtener el area y puesto del usuario");
				response.setStatus("Fail");
			}else {
				
				resp.setNombre(empleadoExist.get().getNombre());
				resp.setApellido1(empleadoExist.get().getApellido1());
				resp.setApellido2(empleadoExist.get().getApellido2());
				resp.setCorreo(empleadoExist.get().getEmailInst());
				resp.setPathFotografia(empleadoExist.get().getPathFotografia());
				
				Optional<InstCatPuestos> puesto =instCatPuestosRepository.findById(empleadoPuesto.get().getIdPuesto().getId());
				resp.setPuesto(puesto.get().getDescNombramiento());
				
				Optional<InstCatAreas> area = instCatAreasRepository.findById(empleadoPuesto.get().getIdCatArea().getId());
				resp.setArea(area.get().getDescArea());
				
				Optional<InstUAdscripcion> unidadAds = instUAdscripcionRepository.findById(area.get().getIdUnAdscripcion().getId());
				resp.setUnidadAdscripcion(unidadAds.get().getDescripcionUnidad());
				
				response.setMessage("Información del Empleado");
				response.setStatus("success");
				response.setData(resp);
			}
			
		}
		
		return response;

		// TODO Auto-generated method stub

	}
}
