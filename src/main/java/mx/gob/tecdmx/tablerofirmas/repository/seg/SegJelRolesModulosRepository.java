package mx.gob.tecdmx.tablerofirmas.repository.seg;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.seg.IDJelRolesModulos;
import mx.gob.tecdmx.tablerofirmas.entity.seg.JelSegRolesModulos;

@Repository
public interface SegJelRolesModulosRepository extends CrudRepository<JelSegRolesModulos, IDJelRolesModulos> {
  
	
}