package mx.gob.tecdmx.tablerofirmas.repository.tab;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.tablerofirmas.entity.tab.TabDocumentoWorkflow;

@Repository
public interface TabDocumentoWorkflowRepository extends CrudRepository<TabDocumentoWorkflow, Integer> {
  
	
}