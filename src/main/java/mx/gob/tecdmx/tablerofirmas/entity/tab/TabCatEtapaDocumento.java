package mx.gob.tecdmx.tablerofirmas.entity.tab;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_cat_etapa_documento", schema = "public")
public class TabCatEtapaDocumento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_etapa_documento", unique = true, nullable = false)
	int  id;
  
	@Column(name = "s_desc_etapa")
	String  descetapa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescetapa() {
		return descetapa;
	}

	public void setDescetapa(String descetapa) {
		this.descetapa = descetapa;
	}

	
	
}