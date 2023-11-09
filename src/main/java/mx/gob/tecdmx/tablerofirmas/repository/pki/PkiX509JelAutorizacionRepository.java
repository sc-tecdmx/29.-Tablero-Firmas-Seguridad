package mx.gob.tecdmx.tablerofirmas.repository.pki;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.pki.PkiX509JelAutorizacion;

@Repository
public interface PkiX509JelAutorizacionRepository extends CrudRepository<PkiX509JelAutorizacion, Integer> {
  
	
}