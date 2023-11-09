package mx.gob.tecdmx.tablerofirmas.repository.seg;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgModulos;

@Repository
public interface SegOrgModulosRepository extends CrudRepository<SegOrgModulos, Integer> {
  
	
}