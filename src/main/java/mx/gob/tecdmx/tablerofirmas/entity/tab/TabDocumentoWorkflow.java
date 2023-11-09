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

@Entity
@Table(name = "tab_documento_workflow", schema = "public")
public class TabDocumentoWorkflow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_documento_workflow", unique = true, nullable = false)
	int  id;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_etapa_documento", referencedColumnName="id_etapa_documento")
	TabCatEtapaDocumento  idEtapaDocumento;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_document", referencedColumnName="n_id_documento")
	TabDocumentos  idDocument;
  
	@Column(name = "ult_actualizacion")
	Date  ultActualizacion;
  
	@Column(name = "workflow_fecha")
	Date  workflowFecha;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="workflow_n_id_num_empleado", referencedColumnName="n_id_num_empleado")
	InstEmpleado  workflowIdNumEmpleado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TabCatEtapaDocumento getIdEtapaDocumento() {
		return idEtapaDocumento;
	}

	public void setIdEtapaDocumento(TabCatEtapaDocumento idEtapaDocumento) {
		this.idEtapaDocumento = idEtapaDocumento;
	}

	public TabDocumentos getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(TabDocumentos idDocument) {
		this.idDocument = idDocument;
	}

	public Date getUltActualizacion() {
		return ultActualizacion;
	}

	public void setUltActualizacion(Date ultActualizacion) {
		this.ultActualizacion = ultActualizacion;
	}

	public Date getWorkflowFecha() {
		return workflowFecha;
	}

	public void setWorkflowFecha(Date workflowFecha) {
		this.workflowFecha = workflowFecha;
	}

	public InstEmpleado getWorkflowIdNumEmpleado() {
		return workflowIdNumEmpleado;
	}

	public void setWorkflowIdNumEmpleado(InstEmpleado workflowIdNumEmpleado) {
		this.workflowIdNumEmpleado = workflowIdNumEmpleado;
	}

	
}