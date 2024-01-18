package mx.gob.tecdmx.tablerofirmas.api.empleados;

public class DTOResponseEmpleado {
	String nombre;
	String apellido1;
	String apellido2;
	String area;
	String puesto;
	String correo;
	String unidadAdscripcion;
	String pathFotografia;
	
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getUnidadAdscripcion() {
		return unidadAdscripcion;
	}
	public void setUnidadAdscripcion(String unidadAdscripcion) {
		this.unidadAdscripcion = unidadAdscripcion;
	}
	public String getPathFotografia() {
		return pathFotografia;
	}
	public void setPathFotografia(String pathFotografia) {
		this.pathFotografia = pathFotografia;
	}
	
}
