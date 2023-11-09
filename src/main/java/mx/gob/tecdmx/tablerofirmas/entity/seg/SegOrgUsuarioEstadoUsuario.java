package mx.gob.tecdmx.tablerofirmas.entity.seg;

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
@Table(name = "seg_org_usuario_estado_usuario", schema = "public")
public class SegOrgUsuarioEstadoUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_usuario_status", unique = true, nullable = false)
	int  id;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_usuario", referencedColumnName="n_id_usuario")
	SegOrgUsuarios  idUsuario;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_estado_usuario", referencedColumnName="n_id_estado_usuario")
	SegCatEstadoUsuario  idEstadoUsuario;
  
	@Column(name = "fingerprint_dispositivo")
	String  fingerprintDispositivo;
  
	@Column(name = "d_fecha_status")
	Date  fechaStatus;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_session_id", referencedColumnName="n_session_id")
	SegOrgLogSesion  sessionId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SegOrgUsuarios getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(SegOrgUsuarios idUsuario) {
		this.idUsuario = idUsuario;
	}

	public SegCatEstadoUsuario getIdEstadoUsuario() {
		return idEstadoUsuario;
	}

	public void setIdEstadoUsuario(SegCatEstadoUsuario idEstadoUsuario) {
		this.idEstadoUsuario = idEstadoUsuario;
	}

	public String getFingerprintDispositivo() {
		return fingerprintDispositivo;
	}

	public void setFingerprintDispositivo(String fingerprintDispositivo) {
		this.fingerprintDispositivo = fingerprintDispositivo;
	}

	public Date getFechaStatus() {
		return fechaStatus;
	}

	public void setFechaStatus(Date fechaStatus) {
		this.fechaStatus = fechaStatus;
	}

	public SegOrgLogSesion getSessionId() {
		return sessionId;
	}

	public void setSessionId(SegOrgLogSesion sessionId) {
		this.sessionId = sessionId;
	}

	
	
}