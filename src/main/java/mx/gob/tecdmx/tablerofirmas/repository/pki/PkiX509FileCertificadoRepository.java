package mx.gob.tecdmx.tablerofirmas.repository.pki;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.pki.PkiX509DocumentoCertificado;

@Repository
public interface PkiX509FileCertificadoRepository extends CrudRepository<PkiX509DocumentoCertificado, Integer> {
  
	
}
