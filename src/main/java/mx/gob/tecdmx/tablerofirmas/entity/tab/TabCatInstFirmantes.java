package mx.gob.tecdmx.tablerofirmas.entity.tab;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_cat_inst_firmantes", schema = "public")
public class TabCatInstFirmantes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_inst_firmante", unique = true, nullable = false)
	int  id;
  
	@Column(name = "desc_instr_firmante")
	String  descInstrFirmante;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescInstrFirmante() {
		return descInstrFirmante;
	}

	public void setDescInstrFirmante(String descInstrFirmante) {
		this.descInstrFirmante = descInstrFirmante;
	}

	


}