package mx.gob.tecdmx.tablerofirmas.api.notificaciones;

public class DTOPayloadNotificacionesEmail {
	String emailDestino;
	String asunto;
	String texto;
	
	public String getEmailDestino() {
		return emailDestino;
	}
	public void setEmailDestino(String emailDestino) {
		this.emailDestino = emailDestino;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
