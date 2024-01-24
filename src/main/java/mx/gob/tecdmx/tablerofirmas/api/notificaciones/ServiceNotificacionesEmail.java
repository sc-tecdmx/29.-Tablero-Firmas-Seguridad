package mx.gob.tecdmx.tablerofirmas.api.notificaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ServiceNotificacionesEmail {

	@Value("${spring.mail.username}")
	private String senderEmail;

	@Autowired
	private JavaMailSender emailSender;

	public boolean sendNotificaciónByEmail(DTOPayloadNotificacionesEmail payload) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(senderEmail);
		message.setTo(payload.getEmailDestino());
		message.setSubject(payload.getAsunto());
		message.setText(payload.getTexto());

		try {
			emailSender.send(message);
			// If no exception is thrown, the email was sent successfully
		} catch (MailException e) {
			return false;
			// Handle the exception, the email was not sent
		}
		return true;

	}
}
