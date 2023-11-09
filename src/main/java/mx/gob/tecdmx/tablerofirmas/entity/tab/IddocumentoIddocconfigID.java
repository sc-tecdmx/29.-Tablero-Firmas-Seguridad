package mx.gob.tecdmx.tablerofirmas.entity.tab;

import java.io.Serializable;

public class IddocumentoIddocconfigID implements Serializable {
	
    private TabDocumentos idDocumento;
    private TabCatDocConfig idDocconfig;
	public TabDocumentos getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(TabDocumentos idDocumento) {
		this.idDocumento = idDocumento;
	}
	public TabCatDocConfig getIdDocconfig() {
		return idDocconfig;
	}
	public void setIdDocconfig(TabCatDocConfig idDocconfig) {
		this.idDocconfig = idDocconfig;
	}
    
    
    
}
