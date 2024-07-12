package mx.gob.tecdmx.tablerofirmas.repository.inst;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstCatPuestos;

@Repository
public interface InstCatPuestosRepository extends CrudRepository<InstCatPuestos, Integer> {
	
	Optional<InstCatPuestos> findByDescNombramiento(String puesto);

	Optional<InstCatPuestos> findById(InstCatPuestos idPuesto);
	
}