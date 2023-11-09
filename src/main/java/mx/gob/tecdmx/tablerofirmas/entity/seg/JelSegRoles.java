package mx.gob.tecdmx.tablerofirmas.entity.seg;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jel_seg_roles", schema = "public")
public class JelSegRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_rol", unique = true, nullable = false)
	int  n_id_rol;
  
	@Column(name = "s_etiqueta_rol")
	String  s_etiqueta_rol;
  
	@Column(name = "s_descripcion")
	String  s_descripcion;
  
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_rol_padre", referencedColumnName="n_id_rol")
	JelSegRoles  n_id_rol_padre;
  
	@Column(name = "n_rec_activo")
	int  n_rec_activo;
  
	@Column(name = "n_session_id_borrado")
	int  n_session_id_borrado;

	public int getN_id_rol() {
		return n_id_rol;
	}

	public void setN_id_rol(int n_id_rol) {
		this.n_id_rol = n_id_rol;
	}

	public String getS_etiqueta_rol() {
		return s_etiqueta_rol;
	}

	public void setS_etiqueta_rol(String s_etiqueta_rol) {
		this.s_etiqueta_rol = s_etiqueta_rol;
	}

	public String getS_descripcion() {
		return s_descripcion;
	}

	public void setS_descripcion(String s_descripcion) {
		this.s_descripcion = s_descripcion;
	}

	public JelSegRoles getN_id_rol_padre() {
		return n_id_rol_padre;
	}

	public void setN_id_rol_padre(JelSegRoles n_id_rol_padre) {
		this.n_id_rol_padre = n_id_rol_padre;
	}

	public int getN_rec_activo() {
		return n_rec_activo;
	}

	public void setN_rec_activo(int n_rec_activo) {
		this.n_rec_activo = n_rec_activo;
	}

	public int getN_session_id_borrado() {
		return n_session_id_borrado;
	}

	public void setN_session_id_borrado(int n_session_id_borrado) {
		this.n_session_id_borrado = n_session_id_borrado;
	}

	
	
}