package mx.gob.tecdmx.tablerofirmas.entity.seg;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jel_seg_modulos", schema = "public")
public class JelSegModulos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_modulo", unique = true, nullable = false)
	int  id;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_nivel", referencedColumnName="n_id_nivel")
	SegCatNivelModulo  n_id_nivel;
  
	@Column(name = "desc_modulo")
	String  desc_modulo;
  
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_modulo_padre", referencedColumnName="n_id_modulo")
	JelSegModulos  n_id_modulo_padre;
  
	@Column(name = "menu")
	String  menu;
  
	@Column(name = "menu_desc")
	String  menu_desc;
  
	@Column(name = "menu_url")
	String  menu_url;
  
	@Column(name = "menu_pos")
	int  menu_pos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SegCatNivelModulo getN_id_nivel() {
		return n_id_nivel;
	}

	public void setN_id_nivel(SegCatNivelModulo n_id_nivel) {
		this.n_id_nivel = n_id_nivel;
	}

	public String getDesc_modulo() {
		return desc_modulo;
	}

	public void setDesc_modulo(String desc_modulo) {
		this.desc_modulo = desc_modulo;
	}

	public JelSegModulos getN_id_modulo_padre() {
		return n_id_modulo_padre;
	}

	public void setN_id_modulo_padre(JelSegModulos n_id_modulo_padre) {
		this.n_id_modulo_padre = n_id_modulo_padre;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getMenu_desc() {
		return menu_desc;
	}

	public void setMenu_desc(String menu_desc) {
		this.menu_desc = menu_desc;
	}

	public String getMenu_url() {
		return menu_url;
	}

	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}

	public int getMenu_pos() {
		return menu_pos;
	}

	public void setMenu_pos(int menu_pos) {
		this.menu_pos = menu_pos;
	}

	
	
}