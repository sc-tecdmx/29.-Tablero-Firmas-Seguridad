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
@Table(name = "jel_seg_roles_modulos", schema = "public")
@IdClass(IDJelRolesModulos.class)
public class JelSegRolesModulos {
	@Id
	@Column(name="n_id_rol")
	Integer nIdRol;
	
	@Id
	@Column(name="n_id_modulo")  
	Integer nIdModulo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_rol", referencedColumnName="n_id_rol", insertable = false, updatable = false)
	private JelSegRoles jelSegRoles;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_modulo", referencedColumnName="n_id_modulo", insertable = false, updatable = false)
	private JelSegModulos jelSegModulos;
  
	@Column(name = "create")
	String  create;
  
	@Column(name = "read")
	String  read;
  
	@Column(name = "update")
	String  update;
  
	@Column(name = "delete")
	String  delete;
  
	@Column(name = "n_session_id")
	int  n_session_id;

	public Integer getnIdRol() {
		return nIdRol;
	}

	public void setnIdRol(Integer nIdRol) {
		this.nIdRol = nIdRol;
	}

	public Integer getnIdModulo() {
		return nIdModulo;
	}

	public void setnIdModulo(Integer nIdModulo) {
		this.nIdModulo = nIdModulo;
	}

	public JelSegRoles getJelSegRoles() {
		return jelSegRoles;
	}

	public void setJelSegRoles(JelSegRoles jelSegRoles) {
		this.jelSegRoles = jelSegRoles;
	}

	public JelSegModulos getJelSegModulos() {
		return jelSegModulos;
	}

	public void setJelSegModulos(JelSegModulos jelSegModulos) {
		this.jelSegModulos = jelSegModulos;
	}

	public String getCreate() {
		return create;
	}

	public void setCreate(String create) {
		this.create = create;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public int getN_session_id() {
		return n_session_id;
	}

	public void setN_session_id(int n_session_id) {
		this.n_session_id = n_session_id;
	}

	
	
}