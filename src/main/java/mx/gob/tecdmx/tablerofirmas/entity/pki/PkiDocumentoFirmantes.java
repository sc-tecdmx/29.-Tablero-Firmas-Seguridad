package mx.gob.tecdmx.tablerofirmas.entity.pki;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleado;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;

@Entity
@Table(name = "pki_documento_firmantes", schema = "public")
@IdClass(HashDocumentoIdUsuarioIdTransaccionID.class)
public class PkiDocumentoFirmantes {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="s_hash_documento", referencedColumnName="s_hash_documento")  
	PkiDocumento  hashDocumento;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_usuario", referencedColumnName="n_id_usuario")
	SegOrgUsuarios  idUsuario;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_transaccion", referencedColumnName="n_id_transaccion")
	PkiTransaccion  idTransaccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_num_empleado", referencedColumnName="n_id_num_empleado")
	InstEmpleado  idNumEmpleado;
  
	@Column(name = "secuencia")
	int  secuencia;
  
	@Column(name = "fecha_limite")
	Date  fechaLimite;
  
	@Column(name = "fecha_firma")
	Date  fechaFirma;
	
	@Column(name="s_descripcion")  
	String descripcion;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_tipo_firma", referencedColumnName="id_tipo_firma")
	PkiCatTipoFirma  idTipoFirma;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_firma_aplicada", referencedColumnName="id_firma_aplicada")
	PkiCatFirmaAplicada  idFirmaAplicada;
	
	@Column(name = "s_cadena_firma")
	String  cadenaFirma;

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

	public InstEmpleado getIdNumEmpleado() {
		return idNumEmpleado;
	}

	public void setIdNumEmpleado(InstEmpleado idNumEmpleado) {
		this.idNumEmpleado = idNumEmpleado;
	}

	public int getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(int secuencia) {
		this.secuencia = secuencia;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public Date getFechaFirma() {
		return fechaFirma;
	}

	public void setFechaFirma(Date fechaFirma) {
		this.fechaFirma = fechaFirma;
	}

	public PkiCatTipoFirma getIdTipoFirma() {
		return idTipoFirma;
	}

	public void setIdTipoFirma(PkiCatTipoFirma idTipoFirma) {
		this.idTipoFirma = idTipoFirma;
	}

	public PkiCatFirmaAplicada getIdFirmaAplicada() {
		return idFirmaAplicada;
	}

	public void setIdFirmaAplicada(PkiCatFirmaAplicada idFirmaAplicada) {
		this.idFirmaAplicada = idFirmaAplicada;
	}

	public String getCadenaFirma() {
		return cadenaFirma;
	}

	public void setCadenaFirma(String cadenaFirma) {
		this.cadenaFirma = cadenaFirma;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}