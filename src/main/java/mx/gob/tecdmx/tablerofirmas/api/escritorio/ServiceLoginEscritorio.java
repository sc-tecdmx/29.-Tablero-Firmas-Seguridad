package mx.gob.tecdmx.tablerofirmas.api.escritorio;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ServiceLoginEscritorio {

	public static void login(PayloadCertLoginEscritorio payload, DTORsponseEscritorio res) {
		// TODO Auto-generated method stub
		InputStream inStream = new ByteArrayInputStream(payload.getCertificado());
		
	}

}
