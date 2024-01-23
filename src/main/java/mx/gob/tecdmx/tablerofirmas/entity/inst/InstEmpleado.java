package mx.gob.tecdmx.tablerofirmas.entity.inst;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;

@Entity
@Table(name = "inst_empleado", schema = "public")
public class InstEmpleado {
	@Id
	@Column(name = "n_id_num_empleado")
	int id;
  
	@Column(name = "nombre")
	String  nombre;
  
	@Column(name = "apellido1")
	String  apellido1;
  
	@Column(name = "apellido2")
	String  apellido2;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_sexo", referencedColumnName="id_sexo") 
	InstCatSexo idSexo;
  
	@Column(name = "s_email_pers")
	String  emailPers;
  
	@Column(name = "s_email_inst")
	String  emailInst;
  
	@Column(name = "tel_pers")
	String  telPers;
  
	@Column(name = "tel_inst")
	String  telInst;
  
	@Column(name = "curp")
	String  curp;
  
	@Column(name = "rfc")
	String  rfc;
  
	@Column(name = "activo")
	boolean  activo;
	
	@Column(name = "path_fotografia")
	String  pathFotografia;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_usuario", referencedColumnName="n_id_usuario") 
	SegOrgUsuarios  idUsuario;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public InstCatSexo getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(InstCatSexo idSexo) {
		this.idSexo = idSexo;
	}

	public String getEmailPers() {
		return emailPers;
	}

	public void setEmailPers(String emailPers) {
		this.emailPers = emailPers;
	}

	public String getEmailInst() {
		return emailInst;
	}

	public void setEmailInst(String emailInst) {
		this.emailInst = emailInst;
	}

	public String getTelPers() {
		return telPers;
	}

	public void setTelPers(String telPers) {
		this.telPers = telPers;
	}

	public String getTelInst() {
		return telInst;
	}

	public void setTelInst(String telInst) {
		this.telInst = telInst;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getPathFotografia() {
		return pathFotografia;
	}

	public void setPathFotografia(String pathFotografia) {
		this.pathFotografia = pathFotografia;
	}

	public SegOrgUsuarios getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(SegOrgUsuarios idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}