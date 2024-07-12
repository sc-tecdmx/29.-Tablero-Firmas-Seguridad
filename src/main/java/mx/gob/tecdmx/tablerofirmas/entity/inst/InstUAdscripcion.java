package mx.gob.tecdmx.tablerofirmas.entity.inst;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inst_u_adscripcion_detalle", schema = "public")
public class InstUAdscripcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_u_adscripcion_detalle", unique = true, nullable = false)
	int id;
  
	@Column(name = "s_desc_unidad")
	String  descripcionUnidad;
  
	@Column(name = "s_abrev_unidad")
	String  abreviacionUnidad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcionUnidad() {
		return descripcionUnidad;
	}

	public void setDescripcionUnidad(String descripcionUnidad) {
		this.descripcionUnidad = descripcionUnidad;
	}

	public String getAbreviacionUnidad() {
		return abreviacionUnidad;
	}

	public void setAbreviacionUnidad(String abreviacionUnidad) {
		this.abreviacionUnidad = abreviacionUnidad;
	}

	
	
}