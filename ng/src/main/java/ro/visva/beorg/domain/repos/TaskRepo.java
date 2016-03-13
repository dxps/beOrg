package ro.visva.beorg.domain.repos;

import ro.visva.beorg.domain.activities.Task;
import ro.visva.beorg.domain.plans.Plan;

import java.util.List;

/**
 * <br><br>
 * 2016-03-13 17:08 | visvadw | Creation time.
 */
public interface TaskRepo {

    boolean add(Task task);

    boolean update(Task task);

    boolean delete(Task task);

    /** List all the tasks associated with a plan. */
    List<Task> listByPlan(Plan plan);

}
