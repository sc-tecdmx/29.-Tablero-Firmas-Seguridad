package mx.gob.tecdmx.tablerofirmas.entity.inst;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inst_cat_puestos", schema = "public")
public class InstCatPuestos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_puesto", unique = true, nullable = false)
	int  id;
  
	@Column(name = "s_desc_nombramiento")
	String  descNombramiento;
  
	@Column(name = "n_tipo_usuario")
	String  tipoUsuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescNombramiento() {
		return descNombramiento;
	}

	public void setDescNombramiento(String descNombramiento) {
		this.descNombramiento = descNombramiento;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	
}