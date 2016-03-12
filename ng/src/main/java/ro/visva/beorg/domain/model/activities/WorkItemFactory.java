package ro.visva.beorg.domain.model.activities;

import ro.visva.beorg.domain.model.plans.Project;

/**
 * <br><br>
 * 2016-03-12 20:55 | visvadw | Creation time.
 */
public class WorkItemFactory {

    public static Activity createActivity(Task parentTask, String name, String description) {
        return new Activity(parentTask, name, description);
    }

    /**
     * Create a new task.
     *
     * @param project     The project to whom the task will belong.
     * @param name        The name of the task.
     * @param description The description of the task.
     * @return The newly created task.
     */
    public static Task createTask(Project project, String name, String description) {
        return new Task(project, name, description);
    }

    public static Task createSubtask(Task parentTask, String name, String description) {
        return new Task(parentTask.project(), name, description);
    }

}
