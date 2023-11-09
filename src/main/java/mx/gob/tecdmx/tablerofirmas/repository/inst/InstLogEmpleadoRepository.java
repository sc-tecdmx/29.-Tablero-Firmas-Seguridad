package mx.gob.tecdmx.tablerofirmas.repository.inst;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstLogEmpleado;

@Repository
public interface InstLogEmpleadoRepository extends CrudRepository<InstLogEmpleado, Integer> {
  
	
}