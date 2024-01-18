package mx.gob.tecdmx.tablerofirmas.api.empleados;

public class PayloadEmpleados {
	int idNumEmpleado;
	String nombre;
	String apellido1;
	String apellido2;
	String codigoSexo;
	String emailPers;
	String emailInst;
	String telPers;
	String telInst;
	String curp;
	String rfc;
	String pathFotografia;
	String codigoArea;
	String codigoPuesto;
	String fechaAltaEmpleado;
	boolean esTitular;
	String fechainicioTitular;
	DTOUsuario usuario;
	
	public int getIdNumEmpleado() {
		return idNumEmpleado;
	}
	public void setIdNumEmpleado(int idNumEmpleado) {
		this.idNumEmpleado = idNumEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getCodigoSexo() {
		return codigoSexo;
	}
	public void setCodigoSexo(String codigoSexo) {
		this.codigoSexo = codigoSexo;
	}
	public String getEmailPers() {
		return emailPers;
	}
	public void setEmailPers(String emailPers) {
		this.emailPers = emailPers;
	}
	public String getEmailInst() {
		return emailInst;
	}
	public void setEmailInst(String emailInst) {
		this.emailInst = emailInst;
	}
	public String getTelPers() {
		return telPers;
	}
	public void setTelPers(String telPers) {
		this.telPers = telPers;
	}
	public String getTelInst() {
		return telInst;
	}
	public void setTelInst(String telInst) {
		this.telInst = telInst;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getPathFotografia() {
		return pathFotografia;
	}
	public void setPathFotografia(String pathFotografia) {
		this.pathFotografia = pathFotografia;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	public String getCodigoPuesto() {
		return codigoPuesto;
	}
	public void setCodigoPuesto(String codigoPuesto) {
		this.codigoPuesto = codigoPuesto;
	}
	public String getFechaAltaEmpleado() {
		return fechaAltaEmpleado;
	}
	public void setFechaAltaEmpleado(String fechaAltaEmpleado) {
		this.fechaAltaEmpleado = fechaAltaEmpleado;
	}
	public boolean isEsTitular() {
		return esTitular;
	}
	public void setEsTitular(boolean esTitular) {
		this.esTitular = esTitular;
	}
	public String getFechainicioTitular() {
		return fechainicioTitular;
	}
	public void setFechainicioTitular(String fechainicioTitular) {
		this.fechainicioTitular = fechainicioTitular;
	}
	public DTOUsuario getUsuario() {
		return usuario;
	}
	public void setUsuario(DTOUsuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
