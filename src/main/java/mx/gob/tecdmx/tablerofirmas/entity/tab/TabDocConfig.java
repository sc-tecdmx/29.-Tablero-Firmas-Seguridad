package mx.gob.tecdmx.tablerofirmas.entity.tab;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "tab_doc_config", schema = "public")
@IdClass(IddocumentoIddocconfigID.class)
public class TabDocConfig {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_documento", referencedColumnName="n_id_documento")
	TabDocumentos  idDocumento;
  
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_doc_config", referencedColumnName="n_id_doc_config")
	TabCatDocConfig  idDocconfig;

	public TabDocumentos getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(TabDocumentos idDocumento) {
		this.idDocumento = idDocumento;
	}

	public TabCatDocConfig getIdDocconfig() {
		return idDocconfig;
	}

	public void setIdDocconfig(TabCatDocConfig idDocconfig) {
		this.idDocconfig = idDocconfig;
	}

	
	
}