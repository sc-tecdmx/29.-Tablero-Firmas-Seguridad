package mx.gob.tecdmx.tablerofirmas.entity.pki;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pki_cat_firma_aplicada", schema = "public")
public class PkiCatFirmaAplicada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_firma_aplicada", unique = true, nullable = false)
	int  id;
  
	@Column(name = "desc_firma_aplicada")
	String  descFirmaAplicada;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescFirmaAplicada() {
		return descFirmaAplicada;
	}

	public void setDescFirmaAplicada(String descFirmaAplicada) {
		this.descFirmaAplicada = descFirmaAplicada;
	}

	
	
	
}