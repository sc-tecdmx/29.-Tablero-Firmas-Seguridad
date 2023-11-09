package mx.gob.tecdmx.tablerofirmas.repository.seg;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.seg.IDRolesModulos;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgRoles;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgRolesModulos;

@Repository
public interface SegOrgRolesModulosRepository extends CrudRepository<SegOrgRolesModulos, IDRolesModulos> {
	List<SegOrgRolesModulos> findBynIdRol(Integer nIdRol);
	List<SegOrgRolesModulos> findBySegOrgRoles(SegOrgRoles rol);
}
