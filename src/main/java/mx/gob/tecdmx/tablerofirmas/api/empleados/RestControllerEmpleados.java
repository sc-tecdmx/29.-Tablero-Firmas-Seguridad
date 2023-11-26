package mx.gob.tecdmx.tablerofirmas.api.empleados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	public ResponseEntity<String> createMenu(@RequestBody PayloadEmpleados payload) {
		SeguridadUtils utils = new SeguridadUtils();
		DTOResponse response = new DTOResponse();
		serviceEmpleados.createEmpleadoV2(payload, response);
		return ResponseEntity.ok().header(null).body(utils.objectToJson(response));
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/fill-data/create-empleado", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> createEmpleado(@RequestBody PayloadEmpleados payload) {
		SeguridadUtils utils = new SeguridadUtils();
		DTOResponse response = new DTOResponse();
		serviceEmpleados.createEmpleado(payload, response);
		return ResponseEntity.ok().header(null).body(utils.objectToJson(response));
	}
	
}
