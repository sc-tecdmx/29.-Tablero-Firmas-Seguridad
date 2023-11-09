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
import javax.persistence.Table;import mx.gob.tecdmx.tablerofirmas.entity.inst.InstUAdscripcion;

@Entity
@Table(name = "seg_org_roles_usuarios", schema = "public")
public class SegOrgRolesUsuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_rol_usuario", unique = true, nullable = false)
	int  id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_rol", referencedColumnName="n_id_rol")
	SegOrgRoles  nIdRol;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_usuario", referencedColumnName="n_id_usuario")
	SegOrgUsuarios  nIdUsuario;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_u_adscripcion", referencedColumnName="n_id_u_adscripcion")
	InstUAdscripcion  nIdUAdscripcion;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_session_id", referencedColumnName="n_session_id")
	SegOrgLogSesion  nSessionId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SegOrgRoles getnIdRol() {
		return nIdRol;
	}

	public void setnIdRol(SegOrgRoles nIdRol) {
		this.nIdRol = nIdRol;
	}

	public SegOrgUsuarios getnIdUsuario() {
		return nIdUsuario;
	}

	public void setnIdUsuario(SegOrgUsuarios nIdUsuario) {
		this.nIdUsuario = nIdUsuario;
	}

	public InstUAdscripcion getnIdUAdscripcion() {
		return nIdUAdscripcion;
	}

	public void setnIdUAdscripcion(InstUAdscripcion nIdUAdscripcion) {
		this.nIdUAdscripcion = nIdUAdscripcion;
	}

	public SegOrgLogSesion getnSessionId() {
		return nSessionId;
	}

	public void setnSessionId(SegOrgLogSesion nSessionId) {
		this.nSessionId = nSessionId;
	}

	
	
	
}