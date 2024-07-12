package mx.gob.tecdmx.tablerofirmas.api.empleados;

import java.util.List;

public class PayloaEditardEmpleados {
	String nombre;
	String apellido1;
	String apellido2;
	String codigoSexo;
	String emailPers;
	String telPers;
	String telInst;
	String curp;
	String rfc;
	String pathFotografia;
	List<DTOEmpleadoPuestoArea> empleadoPuestoArea;
	
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
	public List<DTOEmpleadoPuestoArea> getEmpleadoPuestoArea() {
		return empleadoPuestoArea;
	}
	public void setEmpleadoPuestoArea(List<DTOEmpleadoPuestoArea> empleadoPuestoArea) {
		this.empleadoPuestoArea = empleadoPuestoArea;
	}
}
