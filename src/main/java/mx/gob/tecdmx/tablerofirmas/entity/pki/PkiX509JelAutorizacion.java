package mx.gob.tecdmx.tablerofirmas.entity.pki;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "pki_x509_jel_autorizacion", schema = "public")
public class PkiX509JelAutorizacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_jel_autorizacion", unique = true, nullable = false)
	int  id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_certificado_x509", referencedColumnName="s_x509_serial_number")  
	PkiX509Registrados  idCertificadoX509;
  
	@Column(name = "s_expediente")
	String  expediente;
  
	@Column(name = "s_revocado")
	String  revocado;
  
	@Column(name = "s_token_vigencia")
	String  tokenVigencia;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PkiX509Registrados getIdCertificadoX509() {
		return idCertificadoX509;
	}

	public void setIdCertificadoX509(PkiX509Registrados idCertificadoX509) {
		this.idCertificadoX509 = idCertificadoX509;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	public String getRevocado() {
		return revocado;
	}

	public void setRevocado(String revocado) {
		this.revocado = revocado;
	}

	public String getTokenVigencia() {
		return tokenVigencia;
	}

	public void setTokenVigencia(String tokenVigencia) {
		this.tokenVigencia = tokenVigencia;
	}

	
	
}