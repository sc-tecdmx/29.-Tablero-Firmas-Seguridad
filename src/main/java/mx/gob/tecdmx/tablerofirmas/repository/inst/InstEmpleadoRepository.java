package mx.gob.tecdmx.tablerofirmas.repository.inst;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleado;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;

@Repository
public interface InstEmpleadoRepository extends CrudRepository<InstEmpleado, Integer> {
  Optional<InstEmpleado> findByIdUsuario(SegOrgUsuarios usuario);
	
}