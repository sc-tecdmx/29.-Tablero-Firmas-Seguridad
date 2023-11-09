package mx.gob.tecdmx.tablerofirmas.repository.inst;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstTitularUAdscripcion;

@Repository
public interface InstTitularUAdscripcionRepository extends CrudRepository<InstTitularUAdscripcion, Integer> {
  
	
}