package mx.gob.tecdmx.tablerofirmas.api.administracion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.gob.tecdmx.tablerofirmas.api.menu.ServiceMenu;
import mx.gob.tecdmx.tablerofirmas.entity.seg.IDRolesModulos;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgModulos;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgRoles;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgRolesModulos;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgModulosRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgRolesModulosRepository;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgRolesRepository;
import mx.gob.tecdmx.tablerofirmas.utils.DTOPermisos;
import mx.gob.tecdmx.tablerofirmas.utils.DTOResponse;
import mx.gob.tecdmx.tablerofirmas.utils.PayloadMenu;
import mx.gob.tecdmx.tablerofirmas.utils.ResponseBodyMenu;

@Service
public class ServiceRolesPermisos {

	@Autowired
	SegOrgRolesRepository segOrgRolesRepository;

	@Autowired
	SegOrgRolesModulosRepository segOrgRolesModulosRepository;

	@Autowired
	SegOrgModulosRepository segOrgModulosRepository;

	@Value("${sistema.nombre}")
	private String nombreAplicativo;

	@Autowired
	ServiceMenu ServiceMenu;

	public DTOResponse getPermisosByRol(DTOResponse response, int idRol) {
		ResponseBodyMenu acceso = new ResponseBodyMenu();
		// obtengo el rol
		Optional<SegOrgRoles> rol = segOrgRolesRepository.findById(idRol);
		if (rol.isPresent()) {
			// obtengo las relacion rol-módulos
			List<SegOrgRolesModulos> rolModulos = segOrgRolesModulosRepository.findBySegOrgRoles(rol.get());
			List<PayloadMenu> menu = new ArrayList<PayloadMenu>();
			for (SegOrgRolesModulos rolMod : rolModulos) {
				if (rolMod.getSegOrgModulos().getDescModulo().equals(nombreAplicativo)
						&& rolMod.getSegOrgModulos().getnIdNivel().getDescNivel().equals("Aplicación")) {
					acceso.setAplicacion(rolMod.getSegOrgModulos().getDescModulo());
					int idAplicacion = rolMod.getSegOrgModulos().getId();
					menu = ServiceMenu.fillMenu(rolModulos, menu, idAplicacion);
					acceso.setRol(rol.get().getDescripcion());
					acceso.setMenu(menu);

					response.setStatus("Success");
					response.setMessage("Información obtenida");
					response.setData(acceso);
					return response;

				}

			}
			response.setStatus("fail");
			response.setMessage("no se obtuvo información para este Rol");
			response.setData(acceso);

		}

		return response;
	}

	public DTOResponse editarPermisosByRol(ResponseBodyMenu payload, DTOResponse response, int idRol) {
		IDRolesModulos idRolModulo = null;
		Optional<SegOrgRolesModulos> rolToEdit = null;

		Optional<SegOrgRoles> rol = segOrgRolesRepository.findById(idRol);

		if (rol.isPresent()) {
			for (PayloadMenu menu : payload.getMenu()) {
				// edicion para los módulos
				Optional<SegOrgModulos> modulo = segOrgModulosRepository.findByDescModulo(menu.getNombreModulo());
				idRolModulo = new IDRolesModulos();
				idRolModulo.setnIdRol(rol.get().getId());
				idRolModulo.setnIdModulo(modulo.get().getId());

				rolToEdit = segOrgRolesModulosRepository.findById(idRolModulo);
				for (DTOPermisos permiso : menu.getPermisos()) {
					rolToEdit.get().setCreate(permiso.isCrear() ? "S" : "N");
					rolToEdit.get().setRead(permiso.isLeer() ? "S" : "N");
					rolToEdit.get().setUpdate(permiso.isEditar() ? "S" : "N");
					rolToEdit.get().setDelete(permiso.isEliminar() ? "S" : "N");
					rolToEdit.get().setPublico(permiso.isPublico() ? "S" : "N");
					rolToEdit.get().setN_session_id(null);

					segOrgRolesModulosRepository.save(rolToEdit.get());
				}
				// consulta si existen submodulos dentro del módulo
				if (menu.getModulos().size()> 0) {
					for (PayloadMenu SubModulo : menu.getModulos()) {
						// edición para el caso de submodulos
						Optional<SegOrgModulos> submoduloExist = segOrgModulosRepository
								.findByDescModulo(SubModulo.getNombreModulo());
						idRolModulo = new IDRolesModulos();
						idRolModulo.setnIdRol(rol.get().getId());
						idRolModulo.setnIdModulo(submoduloExist.get().getId());

						rolToEdit = segOrgRolesModulosRepository.findById(idRolModulo);

						for (DTOPermisos permiso : SubModulo.getPermisos()) {
							rolToEdit.get().setCreate(permiso.isCrear() ? "S" : "N");
							rolToEdit.get().setRead(permiso.isLeer() ? "S" : "N");
							rolToEdit.get().setUpdate(permiso.isEditar() ? "S" : "N");
							rolToEdit.get().setDelete(permiso.isEliminar() ? "S" : "N");
							rolToEdit.get().setPublico(permiso.isPublico() ? "S" : "N");
							rolToEdit.get().setN_session_id(null);

							segOrgRolesModulosRepository.save(rolToEdit.get());
						}
					}
				}
			}

			response.setStatus("Success");
			response.setMessage("Actualización finalizada");
			return response;
		}
		
		response.setStatus("fail");
		response.setMessage("no se puedo realizar la actualización para este Rol");
		return response;
	}

}
