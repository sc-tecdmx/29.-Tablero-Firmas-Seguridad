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
@Table(name = "pki_log_usuarios_cert", schema = "public")
public class PkiLogUsuariosCert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_log_usuarios_cert", unique = true, nullable = false)
	int  id;
  
	@Column(name = "s_curp")
	String  curp;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="s_x509_serial_number", referencedColumnName="s_x509_serial_number")  
	PkiX509Registrados  x509SerialNumber;
  
	@Column(name = "s_bitacora")
	String  bitacora;
  
	@Column(name = "s_sha256_registro")
	String  sha256Registro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public PkiX509Registrados getX509SerialNumber() {
		return x509SerialNumber;
	}

	public void setX509SerialNumber(PkiX509Registrados x509SerialNumber) {
		this.x509SerialNumber = x509SerialNumber;
	}

	public String getBitacora() {
		return bitacora;
	}

	public void setBitacora(String bitacora) {
		this.bitacora = bitacora;
	}

	public String getSha256Registro() {
		return sha256Registro;
	}

	public void setSha256Registro(String sha256Registro) {
		this.sha256Registro = sha256Registro;
	}

	
	
}