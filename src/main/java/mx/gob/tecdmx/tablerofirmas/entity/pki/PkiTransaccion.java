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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pki_transaccion", schema = "public")
public class PkiTransaccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_transaccion", unique = true, nullable = false)
	int  id;
  
	@Column(name = "s_request_uuid_filehash")
	String  requestIdFilehash;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="s_x509_serial_number", referencedColumnName="s_x509_serial_number")  
	PkiX509Registrados  x509SerialNumber; 
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="s_uuid_ocsp", referencedColumnName="s_uuid_ocsp")  
	PkiX509Ocsp  idOcsp;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="s_uuid_tsp", referencedColumnName="s_uuid_tsp")  
	PkiX509Tsp  idTsp;
  
	@Column(name = "s_cadena_firma")
	String  cadenaFirma;
	
	@Column(name = "s_request_uuid_filename")
	String  requestIdFilename;
  
	@Column(name = "s_clob_json_request")
	String  clobJsonRequest;
  
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_transaccion_block", referencedColumnName="n_id_transaccion")  
	PkiTransaccion  idTransaccionBlock;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRequestIdFilehash() {
		return requestIdFilehash;
	}

	public void setRequestIdFilehash(String requestIdFilehash) {
		this.requestIdFilehash = requestIdFilehash;
	}

	public PkiX509Registrados getX509SerialNumber() {
		return x509SerialNumber;
	}

	public void setX509SerialNumber(PkiX509Registrados x509SerialNumber) {
		this.x509SerialNumber = x509SerialNumber;
	}

	public PkiX509Ocsp getIdOcsp() {
		return idOcsp;
	}

	public void setIdOcsp(PkiX509Ocsp idOcsp) {
		this.idOcsp = idOcsp;
	}

	public PkiX509Tsp getIdTsp() {
		return idTsp;
	}

	public void setIdTsp(PkiX509Tsp idTsp) {
		this.idTsp = idTsp;
	}

	public String getCadenaFirma() {
		return cadenaFirma;
	}

	public void setCadenaFirma(String cadenaFirma) {
		this.cadenaFirma = cadenaFirma;
	}

	public String getRequestIdFilename() {
		return requestIdFilename;
	}

	public void setRequestIdFilename(String requestIdFilename) {
		this.requestIdFilename = requestIdFilename;
	}

	public String getClobJsonRequest() {
		return clobJsonRequest;
	}

	public void setClobJsonRequest(String clobJsonRequest) {
		this.clobJsonRequest = clobJsonRequest;
	}

	public PkiTransaccion getIdTransaccionBlock() {
		return idTransaccionBlock;
	}

	public void setIdTransaccionBlock(PkiTransaccion idTransaccionBlock) {
		this.idTransaccionBlock = idTransaccionBlock;
	}

	
	
	
}