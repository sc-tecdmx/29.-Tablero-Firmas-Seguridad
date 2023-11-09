package mx.gob.tecdmx.tablerofirmas.entity.inst;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inst_cat_sexo", schema = "public")
public class InstCatSexo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_sexo", unique = true, nullable = false)
	int  id;
  
	@Column(name = "sexo")
	String  sexo;
  
	@Column(name = "sexo_desc")
	String  sexoDesc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexoDesc() {
		return sexoDesc;
	}

	public void setSexoDesc(String sexoDesc) {
		this.sexoDesc = sexoDesc;
	}
	
}