package mx.gob.tecdmx.tablerofirmas.entity.tab;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_cat_inst_dest", schema = "public")
public class TabCatInstDest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_inst_dest", unique = true, nullable = false)
	int  id;
  
	@Column(name = "desc_inst_dest")
	String  descInsDest;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescInsDest() {
		return descInsDest;
	}

	public void setDescInsDest(String descInsDest) {
		this.descInsDest = descInsDest;
	}

	
	
}