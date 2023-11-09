package mx.gob.tecdmx.tablerofirmas.repository.pki;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.pki.PkiX509Ocsp;

@Repository
public interface PkiX509OcspRepository extends CrudRepository<PkiX509Ocsp, String> {

}