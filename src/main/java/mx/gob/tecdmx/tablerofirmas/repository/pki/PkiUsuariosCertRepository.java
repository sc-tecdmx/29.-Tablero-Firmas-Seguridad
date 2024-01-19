package mx.gob.tecdmx.tablerofirmas.repository.pki;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.pki.PkiUsuariosCert;

@Repository
public interface PkiUsuariosCertRepository extends CrudRepository<PkiUsuariosCert, Integer> {
	 Optional<PkiUsuariosCert> findByX509SerialNumber(String serialNumber);
	
}