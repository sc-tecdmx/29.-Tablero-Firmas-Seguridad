package mx.gob.tecdmx.tablerofirmas.entity.seg;

import java.io.Serializable;

public class IDJelRolesUsuarios implements Serializable {
	 
    private Integer nIdRol;
    private Integer nIdUsuario;
    
	public Integer getnIdRol() {
		return nIdRol;
	}
	public void setnIdRol(Integer nIdRol) {
		this.nIdRol = nIdRol;
	}
	public Integer getnIdUsuario() {
		return nIdUsuario;
	}
	public void setnIdUsuario(Integer nIdUsuario) {
		this.nIdUsuario = nIdUsuario;
	}
    
	
	
    
}