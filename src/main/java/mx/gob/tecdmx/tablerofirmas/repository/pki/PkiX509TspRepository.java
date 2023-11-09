package mx.gob.tecdmx.tablerofirmas.repository.pki;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.pki.PkiX509Tsp;

@Repository
public interface PkiX509TspRepository extends CrudRepository<PkiX509Tsp, String> {

}