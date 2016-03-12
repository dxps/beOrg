package ro.visva.beorg.domain.model.plans;

import ro.visva.beorg.domain.model.activities.Task;

import java.util.HashMap;
import java.util.Map;

/**
 * <br><br>
 * 2016-03-12 21:55 | visvadw | Creation time.
 */
public class Project extends Plan {

    private Map<String, Task> tasks = new HashMap<>(1);

    public Project(PlanType type, String name) {
        super(type, name);
    }

    public Project(PlanType type, String name, String description) {
        super(type, name, description);
    }

    /** Add a task to this project. */
    public void addTask(Task task) {
        if (task == null) return;
        tasks.put(task.id(), task);
    }

    /** Remove a task from this project. */
    public void removeTask(Task task) {
        if (task == null) return;
        tasks.remove(task.id(), task);
    }

}
