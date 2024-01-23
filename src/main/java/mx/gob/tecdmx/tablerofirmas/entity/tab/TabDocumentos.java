package mx.gob.tecdmx.tablerofirmas.entity.tab;

import java.util.Date;

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

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleado;
import mx.gob.tecdmx.tablerofirmas.entity.pki.PkiDocumento;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;

@Entity
@Table(name = "tab_documentos", schema = "public")
public class TabDocumentos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_documento", unique = true, nullable = false)
	int  id;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="chain_id_document", referencedColumnName="n_id_documento")
	TabDocumentos chainIdDocument;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_tipo_destino", referencedColumnName="n_id_tipo_destino")
	TabCatDestinoDocumento idTipoDestino;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_tipo_documento", referencedColumnName="n_id_tipo_documento")
	TabCatTipoDocumento idTipoDocumento;
  
	@Column(name = "folio_documento")
	String  folioDocumento;
  
	@Column(name = "folio_especial")
	String  folioEspecial;
	
	@Column(name = "visible")
	boolean  visible;
  
	@Column(name = "creacion_documento_fecha")
	Date  creacionDocumentoFecha;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_num_empleado_creador", referencedColumnName="n_id_num_empleado")
	InstEmpleado idNumEmpleadoCreador;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_usuario_creador", referencedColumnName="n_id_usuario")
	SegOrgUsuarios  idUsuarioCreador; 
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_num_expediente", referencedColumnName="n_num_expediente")
	TabExpedientes  numExpediente;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_prioridad", referencedColumnName="n_id_prioridad")
	TabCatPrioridad  idPrioridad;
  
	@Column(name = "s_asunto")
	String  asunto;
  
	@Column(name = "s_contenido")
	String  contenido;
  
	@Column(name = "d_fecha_limite_firma")
	Date  fechaLimiteFirma;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="s_hash_documento", referencedColumnName="s_hash_documento")
	PkiDocumento  hashDocumento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TabDocumentos getChainIdDocument() {
		return chainIdDocument;
	}

	public void setChainIdDocument(TabDocumentos chainIdDocument) {
		this.chainIdDocument = chainIdDocument;
	}

	public TabCatDestinoDocumento getIdTipoDestino() {
		return idTipoDestino;
	}

	public void setIdTipoDestino(TabCatDestinoDocumento idTipoDestino) {
		this.idTipoDestino = idTipoDestino;
	}

	public TabCatTipoDocumento getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(TabCatTipoDocumento idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getFolioDocumento() {
		return folioDocumento;
	}

	public void setFolioDocumento(String folioDocumento) {
		this.folioDocumento = folioDocumento;
	}

	public String getFolioEspecial() {
		return folioEspecial;
	}

	public void setFolioEspecial(String folioEspecial) {
		this.folioEspecial = folioEspecial;
	}

	public Date getCreacionDocumentoFecha() {
		return creacionDocumentoFecha;
	}

	public void setCreacionDocumentoFecha(Date creacionDocumentoFecha) {
		this.creacionDocumentoFecha = creacionDocumentoFecha;
	}

	public InstEmpleado getIdNumEmpleadoCreador() {
		return idNumEmpleadoCreador;
	}

	public void setIdNumEmpleadoCreador(InstEmpleado idNumEmpleadoCreador) {
		this.idNumEmpleadoCreador = idNumEmpleadoCreador;
	}

	public SegOrgUsuarios getIdUsuarioCreador() {
		return idUsuarioCreador;
	}

	public void setIdUsuarioCreador(SegOrgUsuarios idUsuarioCreador) {
		this.idUsuarioCreador = idUsuarioCreador;
	}

	public TabExpedientes getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(TabExpedientes numExpediente) {
		this.numExpediente = numExpediente;
	}

	public TabCatPrioridad getIdPrioridad() {
		return idPrioridad;
	}

	public void setIdPrioridad(TabCatPrioridad idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFechaLimiteFirma() {
		return fechaLimiteFirma;
	}

	public void setFechaLimiteFirma(Date fechaLimiteFirma) {
		this.fechaLimiteFirma = fechaLimiteFirma;
	}

	public PkiDocumento getHashDocumento() {
		return hashDocumento;
	}

	public void setHashDocumento(PkiDocumento hashDocumento) {
		this.hashDocumento = hashDocumento;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
	
}