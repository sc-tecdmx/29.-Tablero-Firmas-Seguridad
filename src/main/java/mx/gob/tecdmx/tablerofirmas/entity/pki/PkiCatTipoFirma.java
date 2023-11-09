package mx.gob.tecdmx.tablerofirmas.entity.pki;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pki_cat_tipo_firma", schema = "public")
public class PkiCatTipoFirma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_tipo_firma", unique = true, nullable = false)
	int  id;
  
	@Column(name = "desc_tipo_firma")
	String  descTipoFirma;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescTipoFirma() {
		return descTipoFirma;
	}

	public void setDescTipoFirma(String descTipoFirma) {
		this.descTipoFirma = descTipoFirma;
	}

	

}