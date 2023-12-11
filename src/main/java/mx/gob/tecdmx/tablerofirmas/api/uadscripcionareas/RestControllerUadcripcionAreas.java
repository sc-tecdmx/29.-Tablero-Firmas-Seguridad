package mx.gob.tecdmx.tablerofirmas.api.uadscripcionareas;

import java.util.List;

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
public class RestControllerUadcripcionAreas {
	
	@Autowired
	ServiceUadcripcionAreas serviceUadcripcionAreas;

	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/create-uadscripcion-areas", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> createUAdscripcionAreas(@RequestBody PayloadUadcripcionAreas payload) {
		SeguridadUtils utils = new SeguridadUtils();
		DTOResponse response = new DTOResponse();
		serviceUadcripcionAreas.createUadcripcionAreas(payload, response);
		return ResponseEntity.ok().header(null).body(utils.objectToJson(response));
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/create-tipodoc-by-area", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> createTipoDocByArea(@RequestBody List<PayloadTipoDocByArea> payload) {
		SeguridadUtils utils = new SeguridadUtils();
		DTOResponse response = new DTOResponse();
		serviceUadcripcionAreas.createTipoDocByArea(payload, response);
		return ResponseEntity.ok().header(null).body(utils.objectToJson(response));
	}
	
}
