package playground.agileboard.repository;

import org.springframework.data.repository.CrudRepository;
import playground.agileboard.model.WorkItem;

public interface WorkItemRepository extends CrudRepository<WorkItem, Integer> {}
