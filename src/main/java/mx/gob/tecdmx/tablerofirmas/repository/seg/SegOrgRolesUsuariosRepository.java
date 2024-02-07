package mx.gob.tecdmx.tablerofirmas.repository.seg;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgRoles;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgRolesUsuarios;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;

@Repository
public interface SegOrgRolesUsuariosRepository extends CrudRepository<SegOrgRolesUsuarios, Integer> {
	List<SegOrgRolesUsuarios> findByIdUsuario(SegOrgUsuarios usuario);
	Optional<SegOrgRolesUsuarios> findByIdRolAndIdUsuario(SegOrgRoles rol, SegOrgUsuarios user);
}
