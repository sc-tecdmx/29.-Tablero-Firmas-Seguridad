package mx.gob.tecdmx.tablerofirmas.api.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.gob.tecdmx.tablerofirmas.utils.DTOResponse;

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
	
}
