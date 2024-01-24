package mx.gob.tecdmx.tablerofirmas.repository.pki;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.pki.PkiX509Registrados;

@Repository
public interface PkiX509RegistradosRepository extends CrudRepository<PkiX509Registrados, String> {
  Optional<PkiX509Registrados> findByX509SerialNumber(String serialNumber);
	
}