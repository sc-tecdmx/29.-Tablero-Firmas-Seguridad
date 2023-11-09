package mx.gob.tecdmx.tablerofirmas.entity.tab;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_cat_prioridad", schema = "public")
public class TabCatPrioridad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_prioridad", unique = true, nullable = false)
	int  id;
  
	@Column(name = "desc_prioridad")
	String  descPrioridad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescPrioridad() {
		return descPrioridad;
	}

	public void setDescPrioridad(String descPrioridad) {
		this.descPrioridad = descPrioridad;
	}
	
	
	
	
}