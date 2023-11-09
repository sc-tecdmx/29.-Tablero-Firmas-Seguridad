package mx.gob.tecdmx.tablerofirmas.repository.tab;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.tab.TabCatDocConfig;

@Repository
public interface TabCatDocConfigRepository extends CrudRepository<TabCatDocConfig, Integer> {
  
	
}