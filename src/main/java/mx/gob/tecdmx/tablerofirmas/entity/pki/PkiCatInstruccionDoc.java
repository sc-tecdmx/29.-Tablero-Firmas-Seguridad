package mx.gob.tecdmx.tablerofirmas.entity.pki;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pki_cat_instruccion_doc", schema = "public")
public class PkiCatInstruccionDoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_instruccion_doc", unique = true, nullable = false)
	int  id;
  
	@Column(name = "desc_instruccion_doc")
	String  descInstruccionDoc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescInstruccionDoc() {
		return descInstruccionDoc;
	}

	public void setDescInstruccionDoc(String descInstruccionDoc) {
		this.descInstruccionDoc = descInstruccionDoc;
	}

	
	
	
}