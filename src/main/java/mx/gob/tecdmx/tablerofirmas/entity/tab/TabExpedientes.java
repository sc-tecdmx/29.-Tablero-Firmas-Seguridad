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

import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;

@Entity
@Table(name = "tab_expedientes", schema = "public")
public class TabExpedientes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_num_expediente", unique = true, nullable = false)
	int  id;
  
	@Column(name = "s_num_expediente")
	String  numExpediente;
  
	@Column(name = "s_descripcion")
	String  descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_usuario_creador", referencedColumnName="n_id_usuario")
	SegOrgUsuarios idUsuarioCreador;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(String numExpediente) {
		this.numExpediente = numExpediente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public SegOrgUsuarios getIdUsuarioCreador() {
		return idUsuarioCreador;
	}

	public void setIdUsuarioCreador(SegOrgUsuarios idUsuarioCreador) {
		this.idUsuarioCreador = idUsuarioCreador;
	}

	
	
}