package mx.gob.tecdmx.tablerofirmas.api.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendPasswordResetEmail(String destino, String token) {
        String resetUrl = "http://tuDominio.com/reset-password?token=" + token;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("greyz9769@gmai.com");
        message.setTo("paola.montg@gmail.com");
        message.setSubject("Restablecimiento de Contraseña");
        message.setText("Para restablecer tu contraseña, por favor haz clic en el siguiente enlace: " + resetUrl);

        emailSender.send(message);
    }
}