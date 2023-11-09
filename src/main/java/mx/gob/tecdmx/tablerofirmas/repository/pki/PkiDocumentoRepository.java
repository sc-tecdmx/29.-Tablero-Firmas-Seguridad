package mx.gob.tecdmx.tablerofirmas.repository.pki;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.pki.PkiDocumento;

@Repository
public interface PkiDocumentoRepository extends CrudRepository<PkiDocumento, String> {
  
	
}