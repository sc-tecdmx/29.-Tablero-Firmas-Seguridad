package mx.gob.tecdmx.tablerofirmas.repository.seg;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.seg.SegLogUsuario;

@Repository
public interface SegLogUsuarioRepository extends CrudRepository<SegLogUsuario, Integer> {
  
	
}