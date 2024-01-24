package mx.gob.tecdmx.tablerofirmas.repository.pki;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.pki.PkiX509AcAutorizadas;

@Repository
public interface PkiX509AcAutorizadasRepository extends CrudRepository<PkiX509AcAutorizadas, String> {
	Optional<PkiX509AcAutorizadas> findByX509EmisorSerial(String noSerie);
  
}
