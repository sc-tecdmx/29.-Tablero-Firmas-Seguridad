package mx.gob.tecdmx.tablerofirmas.api.notificaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notificaciones/email")
public class RestControllerNotificacionesEmail {

	@Autowired
	ServiceNotificacionesEmail serviceNotificacionesEmail;

	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/send-notificacion", produces = "application/json")
	@ResponseBody
	public boolean requestPasswordReset(@RequestBody DTOPayloadNotificacionesEmail payload) {

		boolean resp = serviceNotificacionesEmail.sendNotificaciónByEmail(payload);
		if (resp) {
			return true;
		}
		return false;
	}
}
