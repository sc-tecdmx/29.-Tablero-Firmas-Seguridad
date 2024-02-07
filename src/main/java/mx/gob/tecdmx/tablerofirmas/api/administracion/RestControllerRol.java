package mx.gob.tecdmx.tablerofirmas.api.administracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.gob.tecdmx.tablerofirmas.utils.DTOResponse;
import mx.gob.tecdmx.tablerofirmas.utils.ResponseBodyMenu;

@RestController
@RequestMapping(path = "/api/seguridad/administracion")
public class RestControllerRol {
	
	@Autowired
	ServiceRolesPermisos serviceRolesPermisos;
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET, path = "/roles-permisos/{idRol}", produces = "application/json")
	public DTOResponse getPermisoByRol(@PathVariable("idRol") int idRol) {
		DTOResponse response = new DTOResponse();
		return serviceRolesPermisos.getPermisosByRol(response, idRol);
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/editar-roles-permisos/{idRol}", produces = "application/json")
	@ResponseBody
	public DTOResponse editarPermisoByRol(@RequestBody ResponseBodyMenu payload, @PathVariable("idRol") int idRol) {
		DTOResponse response = new DTOResponse();
		return serviceRolesPermisos.editarPermisosByRol(payload,response, idRol);
	}

}
