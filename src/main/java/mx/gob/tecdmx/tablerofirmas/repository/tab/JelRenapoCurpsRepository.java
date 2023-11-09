package mx.gob.tecdmx.tablerofirmas.repository.tab;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.tab.JelRenapoCurps;

@Repository
public interface JelRenapoCurpsRepository extends CrudRepository<JelRenapoCurps, Integer> {
  

}