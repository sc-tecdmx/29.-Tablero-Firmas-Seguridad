package mx.gob.tecdmx.tablerofirmas.entity.seg;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seg_cat_nivel_modulo", schema = "public")
public class SegCatNivelModulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_nivel", unique = true)
	int  id;
  
	@Column(name = "desc_nivel")
	String  descNivel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescNivel() {
		return descNivel;
	}

	public void setDescNivel(String descNivel) {
		this.descNivel = descNivel;
	}

	
	
}