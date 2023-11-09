package mx.gob.tecdmx.tablerofirmas.repository.seg;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgLogSesion;

@Repository
public interface SegOrgLogSesionRepository extends CrudRepository<SegOrgLogSesion, Integer> {
  
	
}