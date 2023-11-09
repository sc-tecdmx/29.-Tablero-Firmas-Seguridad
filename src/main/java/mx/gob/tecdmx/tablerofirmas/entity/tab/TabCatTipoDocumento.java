package mx.gob.tecdmx.tablerofirmas.entity.tab;

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

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstCatAreas;

@Entity
@Table(name = "tab_cat_tipo_documento", schema = "public")
public class TabCatTipoDocumento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_tipo_documento", unique = true, nullable = false)
	int  id;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_cat_area", referencedColumnName="n_id_cat_area")
	InstCatAreas idCatArea;
  
	@Column(name = "desc_tipo_documento")
	String  descTipoDocumento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InstCatAreas getIdCatArea() {
		return idCatArea;
	}

	public void setIdCatArea(InstCatAreas idCatArea) {
		this.idCatArea = idCatArea;
	}

	public String getDescTipoDocumento() {
		return descTipoDocumento;
	}

	public void setDescTipoDocumento(String descTipoDocumento) {
		this.descTipoDocumento = descTipoDocumento;
	}

	
	
}