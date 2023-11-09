package mx.gob.tecdmx.tablerofirmas.entity.tab;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_notificaciones", schema = "public")
public class TabNotificaciones {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_notificacion", unique = true, nullable = false)
	int  id;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_document", referencedColumnName="n_id_documento")
	TabDocumentos  idDocument;
  
	@Column(name = "documento_path")
	String  documentoPath;
  
	@Column(name = "message")
	String  message;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_tipo_notif", referencedColumnName="n_id_tipo_notif")
	TabCatTipoNotificacion  idTipoNotif;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TabDocumentos getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(TabDocumentos idDocument) {
		this.idDocument = idDocument;
	}

	public String getDocumentoPath() {
		return documentoPath;
	}

	public void setDocumentoPath(String documentoPath) {
		this.documentoPath = documentoPath;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TabCatTipoNotificacion getIdTipoNotif() {
		return idTipoNotif;
	}

	public void setIdTipoNotif(TabCatTipoNotificacion idTipoNotif) {
		this.idTipoNotif = idTipoNotif;
	}

	
	
}