package mx.gob.tecdmx.tablerofirmas.repository.seg;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;

@Repository
public interface SegOrgUsuariosRepository extends CrudRepository<SegOrgUsuarios, Integer> {
	Optional<SegOrgUsuarios> findBysEmail(String email);
    Optional<SegOrgUsuarios> findBysToken(String resetToken);
	Optional<SegOrgUsuarios> findBysUsuario(String email);
}
