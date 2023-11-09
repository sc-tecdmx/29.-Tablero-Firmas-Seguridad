package mx.gob.tecdmx.tablerofirmas.entity.tab;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_cat_tipo_notificacion", schema = "public")
public class TabCatTipoNotificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_tipo_notif", unique = true, nullable = false)
	int  id;
  
	@Column(name = "desc_tipo")
	String  descTipo;
  
	@Column(name = "icon_tipo_notif")
	String  iconTipoNotif;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescTipo() {
		return descTipo;
	}

	public void setDescTipo(String descTipo) {
		this.descTipo = descTipo;
	}

	public String getIconTipoNotif() {
		return iconTipoNotif;
	}

	public void setIconTipoNotif(String iconTipoNotif) {
		this.iconTipoNotif = iconTipoNotif;
	}

	
	
}