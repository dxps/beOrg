package ro.visva.beorg.domain.repos;

import ro.visva.beorg.domain.activities.Activity;
import ro.visva.beorg.domain.activities.Task;

import java.util.List;

/**
 * <br><br>
 * 2016-03-13 16:47 | visvadw | Creation time.
 */
public interface ActivityRepository extends BaseRepository {

    boolean add(Activity activity);

    boolean update(Activity activity);

    boolean delete(Activity activity);

    List<Activity> listByTask(Task task);

}
