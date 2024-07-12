package mx.gob.tecdmx.tablerofirmas.entity.inst;

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
@Table(name = "inst_empleado_puesto_area", schema = "public")
public class InstEmpleadoPuestoArea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_empleado_puesto_area", unique = true, nullable = false)
	int  id;
  

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_num_empleado", referencedColumnName="n_id_num_empleado") 
	InstEmpleado  idNumEmpleado;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_cat_area", referencedColumnName="n_id_cat_area") 
	InstCatAreas  idCatArea;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_cat_puesto", referencedColumnName="n_id_cat_puesto") 
	InstCatPuestos  idPuesto;
  
	@Column(name = "fecha_alta")
	Date  fechaAlta;
  
	@Column(name = "fecha_conclusion")
	Date  fechaConclusion;
	
	@Column(name = "n_tipo_estructura")
	String  tipoEstructura;
	
	@Column(name = "activo")
	boolean  activo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InstEmpleado getIdNumEmpleado() {
		return idNumEmpleado;
	}

	public void setIdNumEmpleado(InstEmpleado idNumEmpleado) {
		this.idNumEmpleado = idNumEmpleado;
	}

	public InstCatAreas getIdCatArea() {
		return idCatArea;
	}

	public void setIdCatArea(InstCatAreas idCatArea) {
		this.idCatArea = idCatArea;
	}

	public InstCatPuestos getIdPuesto() {
		return idPuesto;
	}

	public void setIdPuesto(InstCatPuestos idPuesto) {
		this.idPuesto = idPuesto;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaConclusion() {
		return fechaConclusion;
	}

	public void setFechaConclusion(Date fechaConclusion) {
		this.fechaConclusion = fechaConclusion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getTipoEstructura() {
		return tipoEstructura;
	}

	public void setTipoEstructura(String tipoEstructura) {
		this.tipoEstructura = tipoEstructura;
	}

	
	
}