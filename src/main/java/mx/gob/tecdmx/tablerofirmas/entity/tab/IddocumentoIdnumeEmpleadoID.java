package mx.gob.tecdmx.tablerofirmas.entity.tab;

import java.io.Serializable;

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleado;

public class IddocumentoIdnumeEmpleadoID implements Serializable {
	 
    private TabDocumentos idDocumento;
    private InstEmpleado idNumEmpleado;
	public TabDocumentos getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(TabDocumentos idDocumento) {
		this.idDocumento = idDocumento;
	}
	public InstEmpleado getIdNumEmpleado() {
		return idNumEmpleado;
	}
	public void setIdNumEmpleado(InstEmpleado idNumEmpleado) {
		this.idNumEmpleado = idNumEmpleado;
	}
    
	
    
}
