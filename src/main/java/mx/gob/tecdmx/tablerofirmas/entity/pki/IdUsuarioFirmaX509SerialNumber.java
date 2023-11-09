package mx.gob.tecdmx.tablerofirmas.entity.pki;

import java.io.Serializable;

import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;

public class IdUsuarioFirmaX509SerialNumber implements Serializable {
	 
    private SegOrgUsuarios idUsuarioFirma;
    private PkiX509Registrados x509SerialNumber;
	public SegOrgUsuarios getIdUsuarioFirma() {
		return idUsuarioFirma;
	}
	public void setIdUsuarioFirma(SegOrgUsuarios idUsuarioFirma) {
		this.idUsuarioFirma = idUsuarioFirma;
	}
	public PkiX509Registrados getX509SerialNumber() {
		return x509SerialNumber;
	}
	public void setX509SerialNumber(PkiX509Registrados x509SerialNumber) {
		this.x509SerialNumber = x509SerialNumber;
	}
    
    
	
}