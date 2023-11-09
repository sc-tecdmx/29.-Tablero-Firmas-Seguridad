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

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleado;
@Entity
@Table(name = "pki_documento", schema = "public")
public class PkiDocumento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "s_hash_documento", unique = true, nullable = false)
	String  hashDocumento;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_num_empleado_creador", referencedColumnName="n_id_num_empleado")
	InstEmpleado  idNumEmpleadoCreador;
  
	@Column(name = "fecha_creacion")
	Date  fechaCreacion;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_num_empleado_envio", referencedColumnName="n_id_num_empleado")
	InstEmpleado  idNumEmpleadoEnvio;
  
	@Column(name = "fecha_envio")
	Date  fechaEnvio;
  
	@Column(name = "s_algoritmo")
	String  algoritmo;
	
	@Column(name = "status_documento")
	String  statusDocumento;
  
	@Column(name = "n_en_orden")
	int  orden;
	
	@Column(name = "terminado")
	int  terminado;

	public String getHashDocumento() {
		return hashDocumento;
	}

	public void setHashDocumento(String hashDocumento) {
		this.hashDocumento = hashDocumento;
	}

	public InstEmpleado getIdNumEmpleadoCreador() {
		return idNumEmpleadoCreador;
	}

	public void setIdNumEmpleadoCreador(InstEmpleado idNumEmpleadoCreador) {
		this.idNumEmpleadoCreador = idNumEmpleadoCreador;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public InstEmpleado getIdNumEmpleadoEnvio() {
		return idNumEmpleadoEnvio;
	}

	public void setIdNumEmpleadoEnvio(InstEmpleado idNumEmpleadoEnvio) {
		this.idNumEmpleadoEnvio = idNumEmpleadoEnvio;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public String getAlgoritmo() {
		return algoritmo;
	}

	public void setAlgoritmo(String algoritmo) {
		this.algoritmo = algoritmo;
	}

	public String getStatusDocumento() {
		return statusDocumento;
	}

	public void setStatusDocumento(String statusDocumento) {
		this.statusDocumento = statusDocumento;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public int getTerminado() {
		return terminado;
	}

	public void setTerminado(int terminado) {
		this.terminado = terminado;
	}

	

}