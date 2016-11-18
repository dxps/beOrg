package ro.visva.beorg.domain.model.repos;

import ro.visva.beorg.domain.model.activities.Task;
import ro.visva.beorg.domain.model.plans.Plan;

import java.util.List;

/**
 * <br><br>
 * 2016-03-13 17:08 | visvadw | Creation time.
 */
public interface TaskRepo extends BaseRepo {

    boolean add(Task task);

    boolean update(Task task);

    boolean delete(Task task);

    /** List all the tasks associated with a plan. */
    List<Task> listByPlan(Plan plan);

}
