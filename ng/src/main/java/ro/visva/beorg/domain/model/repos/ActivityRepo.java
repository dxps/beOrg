package ro.visva.beorg.domain.model.repos;

import ro.visva.beorg.domain.model.activities.Activity;
import ro.visva.beorg.domain.model.activities.Task;

import java.util.List;

/**
 * Activity repository is used for administering the activities.
 * <br><br>
 * 2016-03-13 16:47 | visvadw | Creation time.
 */
public interface ActivityRepo extends BaseRepo {

    boolean add(Activity activity);

    boolean update(Activity activity);

    boolean delete(Activity activity);

    List<Activity> listByTask(Task task);

}
