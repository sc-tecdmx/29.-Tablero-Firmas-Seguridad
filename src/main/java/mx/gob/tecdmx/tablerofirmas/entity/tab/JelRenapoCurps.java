package mx.gob.tecdmx.tablerofirmas.entity.tab;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jel_renapo_curps", schema = "public")
public class JelRenapoCurps {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", unique = true, nullable = false)
	int  id;
  
	@Column(name = "fecha_consulta")
	Date  fechaConsulta;
  
	@Column(name = "respuesta_renapo")
	String  respuestaRenapo;
  
	@Column(name = "respuesta_firmada")
	String  respuestaFirmada;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public String getRespuestaRenapo() {
		return respuestaRenapo;
	}

	public void setRespuestaRenapo(String respuestaRenapo) {
		this.respuestaRenapo = respuestaRenapo;
	}

	public String getRespuestaFirmada() {
		return respuestaFirmada;
	}

	public void setRespuestaFirmada(String respuestaFirmada) {
		this.respuestaFirmada = respuestaFirmada;
	}

	
	
}