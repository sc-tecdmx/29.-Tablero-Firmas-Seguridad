package mx.gob.tecdmx.tablerofirmas.api.email;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.gob.tecdmx.tablerofirmas.api.login.ServiceLogin;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;
import mx.gob.tecdmx.tablerofirmas.repository.seg.SegOrgUsuariosRepository;
import mx.gob.tecdmx.tablerofirmas.utils.DTOResponse;
import mx.gob.tecdmx.tablerofirmas.utils.SeguridadUtils;

@RestController
@RequestMapping("/api/email")
public class RestControllerEmail {

	@Autowired
	ServiceLogin serviceLogin;
	
    @Autowired
    private SegOrgUsuariosRepository userRepository;

    @Autowired
    private EmailService emailService; // You need to implement this service

    @CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/solicitud-reset-password", produces = "application/json")
	@ResponseBody
    public ResponseEntity<String> requestPasswordReset(@RequestParam String email) {
    	DTOResponse response = new DTOResponse();
    	SeguridadUtils utils = new SeguridadUtils();
    	
    	SegOrgUsuarios user = userRepository.findBysEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));

        String resetToken = UUID.randomUUID().toString();
        user.setsToken(resetToken);
        userRepository.save(user);

        // Send email (Implement this in EmailService)
        
        emailService.sendPasswordResetEmail(user.getsEmail(), resetToken);
        
        response.setMessage("Se ha enviado un link para reestablecer la contraseña al correo electronico");
		response.setStatus("Success");
		return ResponseEntity.ok().header(null).body(utils.objectToJson(response));

    }
    @CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/reset-password", produces = "application/json")
	@ResponseBody
    public ResponseEntity<String> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
    	DTOResponse response = new DTOResponse();
    	SeguridadUtils utils = new SeguridadUtils();
    	SegOrgUsuarios user = userRepository.findBysToken(token)
                      .orElseThrow(() -> new IllegalArgumentException("Token inválido"));

//        Update password (make sure to hash the password)
        user.setsContrasenia(serviceLogin.encryptPassword(newPassword)); // Use a password encoder
        user.setsToken(null);
        userRepository.save(user);
        
		response.setMessage("Contraseña actualizada");
		response.setStatus("Success");
		return ResponseEntity.ok().header(null).body(utils.objectToJson(response));
    }
}
