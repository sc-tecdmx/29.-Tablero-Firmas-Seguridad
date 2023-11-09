package mx.gob.tecdmx.tablerofirmas.repository.inst;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstCatSexo;

@Repository
public interface InstCatSexoRepository extends CrudRepository<InstCatSexo, Integer> {
  Optional<InstCatSexo> findBySexo(String sexo);
	
}