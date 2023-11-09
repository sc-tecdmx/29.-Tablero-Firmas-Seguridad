package mx.gob.tecdmx.tablerofirmas.entity.tab;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;
@Entity
@Table(name = "jel_persona_jel", schema = "public")
public class JelPersonaJel {
	@Id
	@Column(name = "s_curp")
	String  curp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_persona_jel", referencedColumnName="n_id_usuario")
	SegOrgUsuarios  idPersonaJel;
  
	@Column(name = "nombre")
	String  nombre;
  
	@Column(name = "apellido1")
	String  apellido1;
  
	@Column(name = "apellido2")
	String  apellido2;
  
	@Column(name = "s_rfc")
	String  rfc;
  
	@Column(name = "genero")
	String  genero;
  
	@Column(name = "fecha_nacimiento")
	Date  fechaNacimiento;
  
	@Column(name = "tipo_identificacion")
	int  tipoIdentificacion;

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public SegOrgUsuarios getIdPersonaJel() {
		return idPersonaJel;
	}

	public void setIdPersonaJel(SegOrgUsuarios idPersonaJel) {
		this.idPersonaJel = idPersonaJel;
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

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(int tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	
	
}