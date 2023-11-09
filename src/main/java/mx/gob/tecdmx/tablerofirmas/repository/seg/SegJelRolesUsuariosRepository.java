package mx.gob.tecdmx.tablerofirmas.repository.seg;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.seg.IDJelRolesUsuarios;
import mx.gob.tecdmx.tablerofirmas.entity.seg.JelSegRolesUsuarios;

@Repository
public interface SegJelRolesUsuariosRepository extends CrudRepository<JelSegRolesUsuarios, IDJelRolesUsuarios> {
  
	
}