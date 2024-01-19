package mx.gob.tecdmx.tablerofirmas.api.escritorio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RestControllerEscritorio {
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/login-escritorio", produces = "application/json")
    public ResponseEntity<DTORsponseEscritorio> loginEscritorio(@RequestBody PayloadCertLoginEscritorio payload) {
		DTORsponseEscritorio res = new DTORsponseEscritorio();
		ServiceLoginEscritorio.login(payload, res);
		return ResponseEntity.ok().header(null).body(res);
	}

}
