package mx.gob.tecdmx.tablerofirmas.entity.pki;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "pki_x509_ocsp", schema = "public")
public class PkiX509Ocsp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "s_uuid_ocsp", unique = true, nullable = false)
	String  id;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="s_x509_serial_number", referencedColumnName="s_x509_serial_number")  
	PkiX509Registrados  x509SerialNumber;
  
	@Column(name = "s_ocsp_response_der_b64")
	String  ocspResponseDerB64;
  
	@Column(name = "s_ocsp_response_path")
	String  ocspResponsePath;
  
	@Column(name = "s_x509_serial_responder")
	String  x509SerialResponder;
  
	@Column(name = "d_fecha_response")
	Date  fechaResponse;
  
	@Column(name = "s_ocsp_indicador")
	String  ocspIndicador;
  
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="s_uuid_ocsp_block", referencedColumnName="s_uuid_ocsp")  
	PkiX509Ocsp  idOcspBlock;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PkiX509Registrados getX509SerialNumber() {
		return x509SerialNumber;
	}

	public void setX509SerialNumber(PkiX509Registrados x509SerialNumber) {
		this.x509SerialNumber = x509SerialNumber;
	}

	public String getOcspResponseDerB64() {
		return ocspResponseDerB64;
	}

	public void setOcspResponseDerB64(String ocspResponseDerB64) {
		this.ocspResponseDerB64 = ocspResponseDerB64;
	}

	public String getOcspResponsePath() {
		return ocspResponsePath;
	}

	public void setOcspResponsePath(String ocspResponsePath) {
		this.ocspResponsePath = ocspResponsePath;
	}

	public String getX509SerialResponder() {
		return x509SerialResponder;
	}

	public void setX509SerialResponder(String x509SerialResponder) {
		this.x509SerialResponder = x509SerialResponder;
	}

	public Date getFechaResponse() {
		return fechaResponse;
	}

	public void setFechaResponse(Date fechaResponse) {
		this.fechaResponse = fechaResponse;
	}

	public String getOcspIndicador() {
		return ocspIndicador;
	}

	public void setOcspIndicador(String ocspIndicador) {
		this.ocspIndicador = ocspIndicador;
	}

	public PkiX509Ocsp getIdOcspBlock() {
		return idOcspBlock;
	}

	public void setIdOcspBlock(PkiX509Ocsp idOcspBlock) {
		this.idOcspBlock = idOcspBlock;
	}

	
}