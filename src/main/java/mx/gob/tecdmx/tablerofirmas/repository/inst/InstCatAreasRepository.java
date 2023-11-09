package mx.gob.tecdmx.tablerofirmas.repository.inst;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstCatAreas;

@Repository
public interface InstCatAreasRepository extends CrudRepository<InstCatAreas, Integer> {
	Optional<InstCatAreas> findByAbrevArea(String area);
	
}