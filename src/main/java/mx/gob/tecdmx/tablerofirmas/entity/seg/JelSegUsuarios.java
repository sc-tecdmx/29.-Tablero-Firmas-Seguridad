package mx.gob.tecdmx.tablerofirmas.entity.seg;

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
@Table(name = "jel_seg_usuarios", schema = "public")
public class JelSegUsuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_usuario", unique = true, nullable = false)
	int  n_id_usuario;
  
	@Column(name = "s_usuario")
	String  s_usuario;
  
	@Column(name = "s_contrasenia")
	String  s_contrasenia;
  
	@Column(name = "s_desc_usuario")
	String  s_desc_usuario;
  
	@Column(name = "s_email")
	String  s_email;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_estado_usuario", referencedColumnName="n_id_estado_usuario")
	SegCatEstadoUsuario  n_id_estado_usuario;
  
	@Column(name = "s_token")
	String  s_token;

	public int getN_id_usuario() {
		return n_id_usuario;
	}

	public void setN_id_usuario(int n_id_usuario) {
		this.n_id_usuario = n_id_usuario;
	}

	public String getS_usuario() {
		return s_usuario;
	}

	public void setS_usuario(String s_usuario) {
		this.s_usuario = s_usuario;
	}

	public String getS_contrasenia() {
		return s_contrasenia;
	}

	public void setS_contrasenia(String s_contrasenia) {
		this.s_contrasenia = s_contrasenia;
	}

	public String getS_desc_usuario() {
		return s_desc_usuario;
	}

	public void setS_desc_usuario(String s_desc_usuario) {
		this.s_desc_usuario = s_desc_usuario;
	}

	public String getS_email() {
		return s_email;
	}

	public void setS_email(String s_email) {
		this.s_email = s_email;
	}

	public SegCatEstadoUsuario getN_id_estado_usuario() {
		return n_id_estado_usuario;
	}

	public void setN_id_estado_usuario(SegCatEstadoUsuario n_id_estado_usuario) {
		this.n_id_estado_usuario = n_id_estado_usuario;
	}

	public String getS_token() {
		return s_token;
	}

	public void setS_token(String s_token) {
		this.s_token = s_token;
	}

	
	
}