package mx.gob.tecdmx.tablerofirmas.entity.pki;

import java.io.Serializable;

import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;

public class HashDocumentoIdUsuarioIdTransaccionID implements Serializable {
	
    private PkiDocumento hashDocumento;
    private SegOrgUsuarios idUsuario;
    private PkiTransaccion idTransaccion;
	public PkiDocumento getHashDocumento() {
		return hashDocumento;
	}
	public void setHashDocumento(PkiDocumento hashDocumento) {
		this.hashDocumento = hashDocumento;
	}
	public SegOrgUsuarios getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(SegOrgUsuarios idUsuario) {
		this.idUsuario = idUsuario;
	}
	public PkiTransaccion getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(PkiTransaccion idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

   
}