package mx.gob.tecdmx.tablerofirmas.api.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Value("${spring.mail.username}")
    private String senderEmail;
	
	@Value("${spring.url.email}")
    private String link;
	
    @Autowired
    private JavaMailSender emailSender;

    public void sendPasswordResetEmail(String destino, String token) {
        String resetUrl = link + token;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderEmail);
        message.setTo(destino);
        message.setSubject("Restablecimiento de Contraseña");
        message.setText("Para restablecer tu contraseña, por favor haz clic en el siguiente enlace: " + resetUrl);

        emailSender.send(message);
    }
}