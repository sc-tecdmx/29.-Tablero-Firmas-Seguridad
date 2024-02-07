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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seg_org_log_sesion", schema = "public")
public class SegOrgLogSesion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_session_id", unique = true, nullable = false)
	int  id;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_usuario", referencedColumnName="n_id_usuario")
	SegOrgUsuarios  n_id_usuario;
  
	@Column(name = "d_fecha_inicio")
	Date  d_fecha_inicio;
  
	@Column(name = "d_fecha_fin")
	Date  d_fecha_fin;
  
	@Column(name = "n_end_sesion")
	long  n_end_sesion;
  
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="chain_n_session_id", referencedColumnName="n_session_id")
	SegOrgLogSesion chain_n_session_id;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SegOrgUsuarios getN_id_usuario() {
		return n_id_usuario;
	}

	public void setN_id_usuario(SegOrgUsuarios n_id_usuario) {
		this.n_id_usuario = n_id_usuario;
	}

	public Date getD_fecha_inicio() {
		return d_fecha_inicio;
	}

	public void setD_fecha_inicio(Date d_fecha_inicio) {
		this.d_fecha_inicio = d_fecha_inicio;
	}

	public Date getD_fecha_fin() {
		return d_fecha_fin;
	}

	public void setD_fecha_fin(Date d_fecha_fin) {
		this.d_fecha_fin = d_fecha_fin;
	}

	public long getN_end_sesion() {
		return n_end_sesion;
	}

	public void setN_end_sesion(long n_end_sesion) {
		this.n_end_sesion = n_end_sesion;
	}

	public SegOrgLogSesion getChain_n_session_id() {
		return chain_n_session_id;
	}

	public void setChain_n_session_id(SegOrgLogSesion chain_n_session_id) {
		this.chain_n_session_id = chain_n_session_id;
	}

	
	
}