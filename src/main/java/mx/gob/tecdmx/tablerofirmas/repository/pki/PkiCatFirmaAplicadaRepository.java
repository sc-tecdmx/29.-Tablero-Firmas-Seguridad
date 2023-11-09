package mx.gob.tecdmx.tablerofirmas.repository.pki;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.pki.PkiCatFirmaAplicada;

@Repository
public interface PkiCatFirmaAplicadaRepository extends CrudRepository<PkiCatFirmaAplicada, Integer> {
  
	
}