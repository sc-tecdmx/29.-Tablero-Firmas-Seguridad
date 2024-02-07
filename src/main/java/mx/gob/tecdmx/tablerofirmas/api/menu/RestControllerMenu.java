package mx.gob.tecdmx.tablerofirmas.api.menu;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.gob.tecdmx.tablerofirmas.utils.DTOResponse;
import mx.gob.tecdmx.tablerofirmas.utils.PayloadMenu;
import mx.gob.tecdmx.tablerofirmas.utils.ResponseBodyMenu;
import mx.gob.tecdmx.tablerofirmas.utils.SeguridadUtils;

@RestController
@RequestMapping(path = "/api/seguridad")
public class RestControllerMenu {
	
	@Autowired
	ServiceMenu menuService;

	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET, path = "/get-menu", produces = "application/json")
	public ResponseBodyMenu version(HttpServletResponse response, Authentication auth) {
		System.out.println(auth.getName());
		return menuService.getMenu(auth);
	}

	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/create-menu", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> createMenu(@RequestBody PayloadMenu payload, Authentication auth) {
		SeguridadUtils utils = new SeguridadUtils();
		DTOResponse response = new DTOResponse();
		menuService.createMenu(payload, response, auth);
		return ResponseEntity.ok().header(null).body(utils.objectToJson(response));
	}
	
}
