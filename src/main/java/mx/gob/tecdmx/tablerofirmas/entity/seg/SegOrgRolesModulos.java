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
@Table(name = "seg_org_roles_modulos", schema = "public")
@IdClass(IDRolesModulos.class)
public class SegOrgRolesModulos {
	@Id
	@Column(name="n_id_rol")
	Integer  nIdRol;
	
	@Id
	@Column(name="n_id_modulo")  
	Integer  nIdModulo;

	@Column(name = "crear")
	String  create;
  
	@Column(name = "leer")
	String  read;
  
	@Column(name = "editar")
	String  update;
  
	@Column(name = "eliminar")
	String  delete;
  
	@Column(name = "publico")
	String  publico;
  
	@Column(name = "n_session_id")
	Integer  n_session_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="n_id_rol", referencedColumnName="n_id_rol", insertable = false, updatable = false)
    private SegOrgRoles segOrgRoles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="n_id_modulo", referencedColumnName="n_id_modulo", insertable = false, updatable = false)
    private SegOrgModulos segOrgModulos;

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

	public SegOrgRoles getSegOrgRoles() {
		return segOrgRoles;
	}

	public void setSegOrgRoles(SegOrgRoles segOrgRoles) {
		this.segOrgRoles = segOrgRoles;
	}

	public SegOrgModulos getSegOrgModulos() {
		return segOrgModulos;
	}

	public void setSegOrgModulos(SegOrgModulos segOrgModulos) {
		this.segOrgModulos = segOrgModulos;
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

	public String getPublico() {
		return publico;
	}

	public void setPublico(String publico) {
		this.publico = publico;
	}

	public Integer getN_session_id() {
		return n_session_id;
	}

	public void setN_session_id(Integer n_session_id) {
		this.n_session_id = n_session_id;
	}

	
}