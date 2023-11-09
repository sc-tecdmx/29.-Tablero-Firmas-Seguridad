package mx.gob.tecdmx.tablerofirmas.entity.inst;

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

import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgLogSesion;

@Entity
@Table(name = "inst_log_empleado", schema = "public")
public class InstLogEmpleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_log_empleado", unique = true, nullable = false)
	int  id;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_num_empleado", referencedColumnName="n_id_num_empleado") 
	InstEmpleado  idNumEmpleado;
  
	@Column(name = "bitacora")
	String  bitacora;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_session_id", referencedColumnName="n_session_id") 
	SegOrgLogSesion  sessionId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InstEmpleado getIdNumEmpleado() {
		return idNumEmpleado;
	}

	public void setIdNumEmpleado(InstEmpleado idNumEmpleado) {
		this.idNumEmpleado = idNumEmpleado;
	}

	public String getBitacora() {
		return bitacora;
	}

	public void setBitacora(String bitacora) {
		this.bitacora = bitacora;
	}

	public SegOrgLogSesion getSessionId() {
		return sessionId;
	}

	public void setSessionId(SegOrgLogSesion sessionId) {
		this.sessionId = sessionId;
	}
	
	
}