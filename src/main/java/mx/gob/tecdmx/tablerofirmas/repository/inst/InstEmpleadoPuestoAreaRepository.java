package mx.gob.tecdmx.tablerofirmas.repository.inst;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstCatAreas;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstCatPuestos;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleado;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstEmpleadoPuestoArea;

@Repository
public interface InstEmpleadoPuestoAreaRepository extends CrudRepository<InstEmpleadoPuestoArea, Integer> {

	List<InstEmpleadoPuestoArea> findByIdNumEmpleado(InstEmpleado idEmpleado);
	Optional<InstEmpleadoPuestoArea> findByIdNumEmpleadoAndIdCatAreaAndIdPuesto(InstEmpleado idEmpleado, InstCatAreas  idCatArea, InstCatPuestos  idPuesto);
  
	
}