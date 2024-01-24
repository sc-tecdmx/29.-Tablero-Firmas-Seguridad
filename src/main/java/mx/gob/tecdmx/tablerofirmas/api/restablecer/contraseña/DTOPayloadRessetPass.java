package mx.gob.tecdmx.tablerofirmas.api.restablecer.contraseña;

public class DTOPayloadRessetPass {
	String token;
	String password;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
