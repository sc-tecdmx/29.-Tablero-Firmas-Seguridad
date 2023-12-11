package mx.gob.tecdmx.tablerofirmas.api.uadscripcionareas;

import java.util.List;

public class PayloadUadcripcionAreas {
	String area;
	Boolean isUnidadAdscripcion;
	String abreviatura;
	List<PayloadUadcripcionAreas> areas;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Boolean getIsUnidadAdscripcion() {
		return isUnidadAdscripcion;
	}
	public void setIsUnidadAdscripcion(Boolean isUnidadAdscripcion) {
		this.isUnidadAdscripcion = isUnidadAdscripcion;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public List<PayloadUadcripcionAreas> getAreas() {
		return areas;
	}
	public void setAreas(List<PayloadUadcripcionAreas> areas) {
		this.areas = areas;
	}
	
	
	
}
