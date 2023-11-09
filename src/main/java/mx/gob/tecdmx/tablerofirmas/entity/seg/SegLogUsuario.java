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
@Table(name = "seg_log_usuario", schema = "public")
public class SegLogUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_log_usuario", unique = true, nullable = false)
	int  id_log_usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_usuario", referencedColumnName="n_id_usuario")
	SegOrgUsuarios  n_id_usuario;
  
	@Column(name = "d_sistema")
	Date  d_sistema;
  
	@Column(name = "n_session_id")
	int  n_session_id; 
  
	@Column(name = "bitacora")
	String  bitacora;

	public int getId_log_usuario() {
		return id_log_usuario;
	}

	public void setId_log_usuario(int id_log_usuario) {
		this.id_log_usuario = id_log_usuario;
	}

	public SegOrgUsuarios getN_id_usuario() {
		return n_id_usuario;
	}

	public void setN_id_usuario(SegOrgUsuarios n_id_usuario) {
		this.n_id_usuario = n_id_usuario;
	}

	public Date getD_sistema() {
		return d_sistema;
	}

	public void setD_sistema(Date d_sistema) {
		this.d_sistema = d_sistema;
	}

	public int getN_session_id() {
		return n_session_id;
	}

	public void setN_session_id(int n_session_id) {
		this.n_session_id = n_session_id;
	}

	public String getBitacora() {
		return bitacora;
	}

	public void setBitacora(String bitacora) {
		this.bitacora = bitacora;
	}

	
	
}