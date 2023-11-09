package mx.gob.tecdmx.tablerofirmas.entity.inst;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inst_cat_areas", schema = "public")
public class InstCatAreas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_cat_area", unique = true, nullable = false)
	int  id;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_u_adscripcion", referencedColumnName="n_id_u_adscripcion")
	InstUAdscripcion  idUnAdscripcion;
  
	@Column(name = "s_desc_area")
	String  descArea;
  
	@Column(name = "s_abrev_area")
	String  abrevArea;
  
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_cat_area_padre", referencedColumnName="n_id_cat_area")
	InstCatAreas  idCatAreaPadre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InstUAdscripcion getIdUnAdscripcion() {
		return idUnAdscripcion;
	}

	public void setIdUnAdscripcion(InstUAdscripcion idUnAdscripcion) {
		this.idUnAdscripcion = idUnAdscripcion;
	}

	public String getDescArea() {
		return descArea;
	}

	public void setDescArea(String descArea) {
		this.descArea = descArea;
	}

	public String getAbrevArea() {
		return abrevArea;
	}

	public void setAbrevArea(String abrevArea) {
		this.abrevArea = abrevArea;
	}

	public InstCatAreas getIdCatAreaPadre() {
		return idCatAreaPadre;
	}

	public void setIdCatAreaPadre(InstCatAreas idCatAreaPadre) {
		this.idCatAreaPadre = idCatAreaPadre;
	}

	
}