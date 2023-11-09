package mx.gob.tecdmx.tablerofirmas.api.empleados;

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleado;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;

public class ResponseBodyEmpleados {
	InstEmpleado empleado;
	SegOrgUsuarios usuario;
	
	public InstEmpleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(InstEmpleado empleado) {
		this.empleado = empleado;
	}
	public SegOrgUsuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(SegOrgUsuarios usuario) {
		this.usuario = usuario;
	}
	
	
}
