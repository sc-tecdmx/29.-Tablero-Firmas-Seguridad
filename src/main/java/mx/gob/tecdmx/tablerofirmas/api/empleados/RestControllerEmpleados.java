package mx.gob.tecdmx.tablerofirmas.api.empleados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.gob.tecdmx.tablerofirmas.utils.DTOResponse;
import mx.gob.tecdmx.tablerofirmas.utils.SeguridadUtils;

@RestController
@RequestMapping(path = "/api/seguridad")
public class RestControllerEmpleados {
	
	@Autowired
	ServiceEmpleados serviceEmpleados;

	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/create-empleado", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> createEmpleado(@RequestBody PayloadEmpleados payload, Authentication auth) {
		SeguridadUtils utils = new SeguridadUtils();
		DTOResponse response = new DTOResponse();
		serviceEmpleados.createEmpleadoV2(payload, response, auth);
		return ResponseEntity.ok().header(null).body(utils.objectToJson(response));
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.PUT, path = "/editar-empleado/{idEmpleado}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> editarEmpleado(@PathVariable("idEmpleado") int idEmpleado,@RequestBody PayloaEditardEmpleados payload, Authentication auth) {
		SeguridadUtils utils = new SeguridadUtils();
		DTOResponse response = new DTOResponse();
		serviceEmpleados.editarEmpleado(idEmpleado,payload, response, auth);
		return ResponseEntity.ok().header(null).body(utils.objectToJson(response));
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar-empleado/{idEmpleado}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<DTOResponse> eliminarEmpleado(@PathVariable("idEmpleado") int idEmpleado, Authentication auth) {
		DTOResponse response = new DTOResponse();
		serviceEmpleados.eliminarEmpleado(idEmpleado, response, auth);
		return ResponseEntity.ok().header(null).body(response);
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET, path = "/consultar-empleado/{idEmpleado}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<DTOResponse> consultarEmpleado(@PathVariable("idEmpleado") int idEmpleado) {
		DTOResponse response = new DTOResponse();
		serviceEmpleados.consultarEmpleado(idEmpleado, response);
		return ResponseEntity.ok().header(null).body(response);
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/fill-data/create-empleado", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> createEmpleadoFillData(@RequestBody PayloadEmpleados payload) {
		SeguridadUtils utils = new SeguridadUtils();
		DTOResponse response = new DTOResponse();
		serviceEmpleados.createEmpleado(payload, response);
		return ResponseEntity.ok().header(null).body(utils.objectToJson(response));
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/fill-data/create-perfil", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> createPerfil(@RequestBody PayloadPerfiles payload) {
		SeguridadUtils utils = new SeguridadUtils();
		DTOResponse response = new DTOResponse();
		serviceEmpleados.createPerfil(payload, response);
		return ResponseEntity.ok().header(null).body(utils.objectToJson(response));
	}
	
}
