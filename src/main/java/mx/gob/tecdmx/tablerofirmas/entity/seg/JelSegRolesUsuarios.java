package mx.gob.tecdmx.tablerofirmas.entity.seg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "jel_seg_roles_usuarios", schema = "public")
@IdClass(IDJelRolesUsuarios.class)
public class JelSegRolesUsuarios {
	
	
	@Id
	@Column(name="n_id_rol")
	Integer  nIdRol;
		
	@Id
	@Column(name="n_id_usuario")  
	Integer  nIdUsuario;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_rol", referencedColumnName="n_id_rol", insertable = false, updatable = false)
	JelSegRoles  jelSegRoles;
  
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_usuario", referencedColumnName="n_id_usuario", insertable = false, updatable = false)
	JelSegUsuarios jelSegUsuarios;

	public Integer getnIdRol() {
		return nIdRol;
	}

	public void setnIdRol(Integer nIdRol) {
		this.nIdRol = nIdRol;
	}

	public Integer getnIdUsuario() {
		return nIdUsuario;
	}

	public void setnIdUsuario(Integer nIdUsuario) {
		this.nIdUsuario = nIdUsuario;
	}

	public JelSegRoles getJelSegRoles() {
		return jelSegRoles;
	}

	public void setJelSegRoles(JelSegRoles jelSegRoles) {
		this.jelSegRoles = jelSegRoles;
	}

	public JelSegUsuarios getJelSegUsuarios() {
		return jelSegUsuarios;
	}

	public void setJelSegUsuarios(JelSegUsuarios jelSegUsuarios) {
		this.jelSegUsuarios = jelSegUsuarios;
	}

	
	
}