package playground.agileboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import playground.agileboard.model.WorkItem;

@Repository
public interface WorkItemRepository extends CrudRepository<WorkItem, Integer> {}
