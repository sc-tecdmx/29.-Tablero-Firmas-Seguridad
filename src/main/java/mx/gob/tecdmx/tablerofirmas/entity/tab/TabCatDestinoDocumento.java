package mx.gob.tecdmx.tablerofirmas.entity.tab;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_cat_destino_documento", schema = "public")
public class TabCatDestinoDocumento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_tipo_destino", unique = true, nullable = false)
	int  id;
  
	@Column(name = "desc_destino_documento")
	String  descDestinoDocumento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescDestinoDocumento() {
		return descDestinoDocumento;
	}

	public void setDescDestinoDocumento(String descDestinoDocumento) {
		this.descDestinoDocumento = descDestinoDocumento;
	}

	
	
}