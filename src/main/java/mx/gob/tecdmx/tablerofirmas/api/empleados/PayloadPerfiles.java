package mx.gob.tecdmx.tablerofirmas.api.empleados;

import java.util.Date;

public class PayloadPerfiles {
	int idNumEmpleado;
	int idCatArea;
	int idCatPuesto;
	Date fhConclusion;
	String tipoEstructura;
	
	int idRol;
	int idUsuario;
	int idUAdscripcionDetalle;
	
	public int getIdNumEmpleado() {
		return idNumEmpleado;
	}
	public void setIdNumEmpleado(int idNumEmpleado) {
		this.idNumEmpleado = idNumEmpleado;
	}
	public int getIdCatArea() {
		return idCatArea;
	}
	public void setIdCatArea(int idCatArea) {
		this.idCatArea = idCatArea;
	}
	public int getIdCatPuesto() {
		return idCatPuesto;
	}
	public void setIdCatPuesto(int idCatPuesto) {
		this.idCatPuesto = idCatPuesto;
	}
	public Date getFhConclusion() {
		return fhConclusion;
	}
	public void setFhConclusion(Date fhConclusion) {
		this.fhConclusion = fhConclusion;
	}
	public String getTipoEstructura() {
		return tipoEstructura;
	}
	public void setTipoEstructura(String tipoEstructura) {
		this.tipoEstructura = tipoEstructura;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdUAdscripcionDetalle() {
		return idUAdscripcionDetalle;
	}
	public void setIdUAdscripcionDetalle(int idUAdscripcionDetalle) {
		this.idUAdscripcionDetalle = idUAdscripcionDetalle;
	}
	
	
	
}
