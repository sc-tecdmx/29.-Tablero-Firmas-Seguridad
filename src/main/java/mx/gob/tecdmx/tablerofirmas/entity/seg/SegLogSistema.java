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
@Table(name = "seg_log_sistema", schema = "public")
public class SegLogSistema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_log_sistema", unique = true, nullable = false)
	int  id_log_sistema;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_usuario_org", referencedColumnName="n_id_usuario")
	SegOrgUsuarios  n_id_usuario_org;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_usuario_jel", referencedColumnName="n_id_usuario")
	JelSegUsuarios  n_id_usuario_jel;
  
	@Column(name = "d_sistema")
	Date  d_sistema;
  
	@Column(name = "bitacora")
	String  bitacora;

	public int getId_log_sistema() {
		return id_log_sistema;
	}

	public void setId_log_sistema(int id_log_sistema) {
		this.id_log_sistema = id_log_sistema;
	}

	public SegOrgUsuarios getN_id_usuario_org() {
		return n_id_usuario_org;
	}

	public void setN_id_usuario_org(SegOrgUsuarios n_id_usuario_org) {
		this.n_id_usuario_org = n_id_usuario_org;
	}

	public JelSegUsuarios getN_id_usuario_jel() {
		return n_id_usuario_jel;
	}

	public void setN_id_usuario_jel(JelSegUsuarios n_id_usuario_jel) {
		this.n_id_usuario_jel = n_id_usuario_jel;
	}

	public Date getD_sistema() {
		return d_sistema;
	}

	public void setD_sistema(Date d_sistema) {
		this.d_sistema = d_sistema;
	}

	public String getBitacora() {
		return bitacora;
	}

	public void setBitacora(String bitacora) {
		this.bitacora = bitacora;
	}

	
	
}