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
import javax.persistence.Table;
@Entity
@Table(name = "pki_x509_registrados", schema = "public")
public class PkiX509Registrados {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "s_x509_serial_number", unique = true)
	String  x509SerialNumber;
  
	@Column(name = "s_x509_der_b64")
	String  x509DerB64;
  
	@Column(name = "s_x509_sha256_cert")
	String  x509Sha256Cert;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="s_x509_emisor_serial", referencedColumnName="s_x509_emisor_serial")  
	PkiX509AcAutorizadas  x509EmisorSerial;
	
	@Column(name = "s_x509_subject")
	String  x509Subject;
  
	@Column(name = "s_x509_rfc")
	String  x509Rfc;
  
	@Column(name = "s_x509_curp")
	String  x509Curp;
  
	@Column(name = "s_x509_nombre")
	String  x509Nombre; 
  
	@Column(name = "s_x509_apellido1")
	String  x509Apellido1; 
  
	@Column(name = "s_x509_apellido2")
	String  x509Apellido2;
  
	@Column(name = "s_sha256_registro")
	String  sha256Registro;
  
	@Column(name = "s_token_vigencia")
	String  tokenVigencia;
  
	@Column(name = "d_fecha_registro")
	Date  fechaFegistro;
  
	@Column(name = "d_fecha_revocacion")
	Date  fechaRevocacion;

	public String getX509SerialNumber() {
		return x509SerialNumber;
	}

	public void setX509SerialNumber(String x509SerialNumber) {
		this.x509SerialNumber = x509SerialNumber;
	}

	public String getX509DerB64() {
		return x509DerB64;
	}

	public void setX509DerB64(String x509DerB64) {
		this.x509DerB64 = x509DerB64;
	}

	public String getX509Sha256Cert() {
		return x509Sha256Cert;
	}

	public void setX509Sha256Cert(String x509Sha256Cert) {
		this.x509Sha256Cert = x509Sha256Cert;
	}

	public PkiX509AcAutorizadas getX509EmisorSerial() {
		return x509EmisorSerial;
	}

	public void setX509EmisorSerial(PkiX509AcAutorizadas x509EmisorSerial) {
		this.x509EmisorSerial = x509EmisorSerial;
	}

	public String getX509Subject() {
		return x509Subject;
	}

	public void setX509Subject(String x509Subject) {
		this.x509Subject = x509Subject;
	}

	public String getX509Rfc() {
		return x509Rfc;
	}

	public void setX509Rfc(String x509Rfc) {
		this.x509Rfc = x509Rfc;
	}

	public String getX509Curp() {
		return x509Curp;
	}

	public void setX509Curp(String x509Curp) {
		this.x509Curp = x509Curp;
	}

	public String getX509Nombre() {
		return x509Nombre;
	}

	public void setX509Nombre(String x509Nombre) {
		this.x509Nombre = x509Nombre;
	}

	public String getX509Apellido1() {
		return x509Apellido1;
	}

	public void setX509Apellido1(String x509Apellido1) {
		this.x509Apellido1 = x509Apellido1;
	}

	public String getX509Apellido2() {
		return x509Apellido2;
	}

	public void setX509Apellido2(String x509Apellido2) {
		this.x509Apellido2 = x509Apellido2;
	}

	public String getSha256Registro() {
		return sha256Registro;
	}

	public void setSha256Registro(String sha256Registro) {
		this.sha256Registro = sha256Registro;
	}

	public String getTokenVigencia() {
		return tokenVigencia;
	}

	public void setTokenVigencia(String tokenVigencia) {
		this.tokenVigencia = tokenVigencia;
	}

	public Date getFechaFegistro() {
		return fechaFegistro;
	}

	public void setFechaFegistro(Date fechaFegistro) {
		this.fechaFegistro = fechaFegistro;
	}

	public Date getFechaRevocacion() {
		return fechaRevocacion;
	}

	public void setFechaRevocacion(Date fechaRevocacion) {
		this.fechaRevocacion = fechaRevocacion;
	}

	
	
}