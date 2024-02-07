package mx.gob.tecdmx.tablerofirmas.repository.seg;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarioEstadoUsuario;
import mx.gob.tecdmx.tablerofirmas.entity.seg.SegOrgUsuarios;

@Repository
public interface SegOrgUsuarioEstadoUsuarioRepository extends CrudRepository<SegOrgUsuarioEstadoUsuario, Integer> {
	Optional<SegOrgUsuarioEstadoUsuario> findByIdUsuario(SegOrgUsuarios idUser);
	
}