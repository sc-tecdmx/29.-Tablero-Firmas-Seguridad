package mx.gob.tecdmx.tablerofirmas.api.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstCatPuestos;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleadoPuestoArea;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegCatNivelModulo;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgLogSesion;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgModulos;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgRoles;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgRolesModulos;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgRolesUsuarios;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstCatPuestosRepository;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstEmpleadoPuestoAreaRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegCatNivelModuloRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgLogSesionRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgModulosRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgRolesModulosRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgRolesRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgRolesUsuariosRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgUsuariosRepository;
import mx.gob.tecdmx.tablerofirmas.utils.DTOPermisos;
import mx.gob.tecdmx.tablerofirmas.utils.DTOResponse;
import mx.gob.tecdmx.tablerofirmas.utils.PayloadMenu;
import mx.gob.tecdmx.tablerofirmas.utils.PerfilDTO;
import mx.gob.tecdmx.tablerofirmas.utils.ResponseBodyMenu;
import mx.gob.tecdmx.tablerofirmas.utils.VOUsuario;

@Service
public class ServiceMenu {

	@Autowired
	private SegOrgUsuariosRepository segOrgUsuariosRepository;

	@Autowired
	private SegOrgRolesUsuariosRepository segOrgRolesUsuariosRepository;

	@Autowired
	private SegOrgRolesModulosRepository segOrgRolesModulosRepository;

	@Autowired
	SegOrgModulosRepository segOrgModulosRepository;

	@Autowired
	SegCatNivelModuloRepository segCatNivelModuloRepository;

	@Autowired
	SegOrgRolesRepository segOrgRolesRepository;

	@Autowired
	SegOrgLogSesionRepository segOrgLogSesionRepository;

	@Autowired
	InstEmpleadoPuestoAreaRepository empleadoPuestoAreaRepository;
	
	@Autowired
	private InstCatPuestosRepository instCatPuestosRepository;

	@Value("${sistema.nombre}")
	private String nombreAplicativo;

	public List<PayloadMenu> fillMenu(List<SegOrgRolesModulos> rolesModulos, List<PayloadMenu> menu, int parentId) {
		PayloadMenu menuChild = null;
		DTOPermisos permisos = null;
		for (SegOrgRolesModulos rolMod : rolesModulos) {
			if (rolMod.getSegOrgModulos().getnIdModuloPadre().getId() == parentId) {
				menuChild = new PayloadMenu();
				permisos = new DTOPermisos();
				menuChild.setNombreModulo(rolMod.getSegOrgModulos().getDescModulo());
				menuChild.setPos(rolMod.getSegOrgModulos().getMenuPos());
				menuChild.setNivelModulo(rolMod.getSegOrgModulos().getnIdNivel().getDescNivel());
				permisos.setCrear(rolMod.getCreate().equals("S") ? true : false);
				permisos.setEditar(rolMod.getUpdate().equals("S") ? true : false);
				permisos.setEliminar(rolMod.getDelete().equals("S") ? true : false);
				permisos.setLeer(rolMod.getRead().equals("S") ? true : false);
				permisos.setCodigoRol(rolMod.getSegOrgRoles().getEtiquetaRol());

				List<DTOPermisos> permisosList = new ArrayList<DTOPermisos>();
				permisosList.add(permisos);
				menuChild.setPermisos(permisosList);

				menuChild.setUrl(rolMod.getSegOrgModulos().getMenuUrl());
				List<PayloadMenu> childMenus = new ArrayList<PayloadMenu>();
				fillMenu(rolesModulos, childMenus, rolMod.getSegOrgModulos().getId());
				menuChild.setModulos(childMenus);
				menu.add(menuChild);
			}

		}
		return menu;
	}

	public List<PerfilDTO> getMenu(ResponseBodyMenu acceso, SegOrgUsuarios usuario) {
		List<SegOrgRolesUsuarios> rolesUsuario = segOrgRolesUsuariosRepository.findByIdUsuario(usuario);
		List<ResponseBodyMenu> accsesosRolesPeril = new ArrayList<ResponseBodyMenu>();
		List<PerfilDTO> perfiles = new ArrayList<PerfilDTO>();

		// Buscar los menus a los que tiene acceso en una determinada aplicación
		for (SegOrgRolesUsuarios usuarioRol : rolesUsuario) {
			acceso = new ResponseBodyMenu();
			System.out.println(usuarioRol.getIdRol().getId());
			System.out.println(usuarioRol.getIdRol().getDescripcion());
			Optional<InstEmpleadoPuestoArea> perfilEmpleado = empleadoPuestoAreaRepository
					.findById(usuarioRol.getIdEmpleadoPuestoArea().getId());
			if (perfilEmpleado.isPresent() && perfilEmpleado.get().isActivo()) {
				// Se devuelve siempre y cuando se se encuentre activo
				List<SegOrgRolesModulos> rolesModulos = segOrgRolesModulosRepository
						.findBySegOrgRoles(usuarioRol.getIdRol());
				List<PayloadMenu> menu = new ArrayList<PayloadMenu>();
				for (SegOrgRolesModulos rolMod : rolesModulos) {
					if (rolMod.getSegOrgModulos().getDescModulo().equals(nombreAplicativo)
							&& rolMod.getSegOrgModulos().getnIdNivel().getDescNivel().equals("Aplicación")) {
						acceso.setAplicacion(rolMod.getSegOrgModulos().getDescModulo());
						int idAplicacion = rolMod.getSegOrgModulos().getId();
						fillMenu(rolesModulos, menu, idAplicacion);
						acceso.setRol(usuarioRol.getIdRol().getDescripcion());
						acceso.setMenu(menu);
					}
					System.out.println(rolMod.getSegOrgModulos().getDescModulo());
					System.out.println(rolMod.getSegOrgModulos().getnIdNivel().getDescNivel());
				}
				
				Optional<InstCatPuestos> puesto = instCatPuestosRepository.findById(perfilEmpleado.get().getIdPuesto().getId());
				PerfilDTO perfil = new PerfilDTO();
				perfil.setPerfil(puesto.get().getDescNombramiento());
				perfil.setMenu(acceso);
				perfiles.add(perfil);
			}
		}
		return perfiles;
	}

	public List<PerfilDTO> getMenu(Authentication auth) {
		VOUsuario usuario = (VOUsuario) auth.getDetails();
		Optional<SegOrgUsuarios> credentials = segOrgUsuariosRepository.findBysEmail(usuario.getEmail());
		ResponseBodyMenu acceso = new ResponseBodyMenu();
		List<PerfilDTO> perfiles = null;
		if (credentials.isPresent()) {
			 perfiles = getMenu(acceso, credentials.get());
		}
		return perfiles;
	}

//	----------------
	public SegCatNivelModulo findNivel(String nivel) {
		Optional<SegCatNivelModulo> nivelModulo = segCatNivelModuloRepository.findByDescNivel(nivel);
		if (nivelModulo.isPresent()) {
			return nivelModulo.get();
		}
		return null;
	}

	public boolean validateNivelAndPermisos(PayloadMenu payload) {
		SegCatNivelModulo nivelModulo = findNivel(payload.getNivelModulo());
		if (nivelModulo == null) {
			return false;
		}
		if (payload.getModulos() != null) {
			for (PayloadMenu moduloPayload : payload.getModulos()) {
				return validateNivelAndPermisos(moduloPayload);
			}
		}

		if (payload.getPermisos() != null) {
			for (DTOPermisos permiso : payload.getPermisos()) {
				Optional<SegOrgRoles> rol = segOrgRolesRepository.findByEtiquetaRol(permiso.getCodigoRol());
				if (!rol.isPresent()) {
					return false;
				}
			}
		}
		return true;
	}

	public SegOrgModulos storeMenu(PayloadMenu payload, int pos, SegOrgModulos padreid, DTOResponse response,
			Authentication auth) {
		SegOrgModulos moduloPadre = null;

		SegOrgModulos modulo = new SegOrgModulos();

//		VOUsuario usuarioVO = (VOUsuario) auth.getDetails();
//		Optional<SegOrgLogSesion> sesionExist = segOrgLogSesionRepository
//				.findById(Integer.parseInt(usuarioVO.getIdSession()));

		SegCatNivelModulo nivelModulo = findNivel(payload.getNivelModulo());
		modulo.setnIdNivel(nivelModulo);
		modulo.setDescModulo(payload.getNombreModulo());

		if (payload.getNivelModulo().equals("Aplicación")) {
			Optional<SegOrgModulos> moduloNoParent = segOrgModulosRepository.findById(-1);
			modulo.setnIdModuloPadre(moduloNoParent.get());
			modulo.setMenu("N");
			modulo.setMenuUrl(null);
			modulo.setMenuPos(1);

		} else {
			modulo.setnIdModuloPadre(padreid);
			modulo.setMenu("S");
			modulo.setMenuUrl(payload.getUrl());
			modulo.setMenuPos(pos);

		}

		moduloPadre = segOrgModulosRepository.save(modulo);
		if (payload.getModulos() != null) {
			for (int i = 0; i < payload.getModulos().size(); i++) {
				storeMenu(payload.getModulos().get(i), i + 1, moduloPadre, response, auth);
			}
		}

		if (payload.getPermisos() != null) {
			for (DTOPermisos permiso : payload.getPermisos()) {

				Optional<SegOrgRoles> rol = segOrgRolesRepository.findByEtiquetaRol(permiso.getCodigoRol());
				if (rol.isPresent()) {
					SegOrgRolesModulos rolToSave = new SegOrgRolesModulos();
					rolToSave.setnIdRol(rol.get().getId());
					rolToSave.setnIdModulo(moduloPadre.getId());
					rolToSave.setCreate(permiso.isCrear() ? "S" : "N");
					rolToSave.setRead(permiso.isLeer() ? "S" : "N");
					rolToSave.setUpdate(permiso.isEditar() ? "S" : "N");
					rolToSave.setDelete(permiso.isEliminar() ? "S" : "N");
					rolToSave.setPublico(permiso.isPublico() ? "S" : "N");
//					rolToSave.setN_session_id(sesionExist.get().getId());

					segOrgRolesModulosRepository.save(rolToSave);
				}

			}
		}
		response.setData(moduloPadre);
		return moduloPadre;
	}

	public DTOResponse createMenu(PayloadMenu payload, DTOResponse response, Authentication auth) {

		boolean hasNivel = validateNivelAndPermisos(payload);

		if (!hasNivel) {
			response.setMessage("El/Los nivel(es) especificado(s) no existe(n)");
			response.setStatus("Fail");
			return response;
		}
		SegOrgModulos moduloStored = storeMenu(payload, 1, null, response, auth);
		if (moduloStored != null) {
			response.setMessage("EL menú se ha guardado exitósamente");
			response.setStatus("Success");
		}
		return response;
	}

}
