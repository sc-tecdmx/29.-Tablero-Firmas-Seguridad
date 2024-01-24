package mx.gob.tecdmx.tablerofirmas.api.empleados;

import java.sql.Date;

public class DTOCertificado {
	String noSerie;
	String emisor;
	String fchRegistro;
	String fchRevocación;

	public String getNoSerie() {
		return noSerie;
	}

	public void setNoSerie(String noSerie) {
		this.noSerie = noSerie;
	}
	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getFchRegistro() {
		return fchRegistro;
	}

	public void setFchRegistro(String fchRegistro) {
		this.fchRegistro = fchRegistro;
	}

	public String getFchRevocación() {
		return fchRevocación;
	}

	public void setFchRevocación(String fchRevocación) {
		this.fchRevocación = fchRevocación;
	}

}
