package mx.gob.tecdmx.tablerofirmas.api.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.gob.tecdmx.tablerofirmas.api.empleados.DTOUsuario;
import mx.gob.tecdmx.tablerofirmas.utils.DTOResponse;
import mx.gob.tecdmx.tablerofirmas.utils.SeguridadUtils;

@RestController
@RequestMapping(path = "/api/seguridad")
public class RestControllerUsuarios {

	@Autowired
	UserService userService;
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/userinfo", produces = "application/json")
	@ResponseBody
	public DTOResponse userInfo(Authentication auth) {
		DTOResponse response = new DTOResponse();
		return userService.userInfo(auth, response);
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/registrar-usuario", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> createUsuario(@RequestBody DTOUsuario user) {
		SeguridadUtils utils = new SeguridadUtils();
		DTOResponse response = new DTOResponse();
		userService.createUser(user, response);
		return ResponseEntity.ok().header(null).body(utils.objectToJson(response));
	}
	
	
}
