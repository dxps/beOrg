package ro.visva.beorg.domain.model.tasks;

import ro.visva.beorg.domain.model.plans.Plan;

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
     * @param plan        The plan this task will belong.
     * @param name        The name of the task.
     * @param description The description of the task.
     * @return The newly created task.
     */
    public static Task createTask(Plan plan, String name, String description) {
        return new Task(plan, name, description);
    }

    /**
     * Create a new subtask.
     *
     * @param parentTask  The parent task it belongs to.
     * @param name        The name of the task.
     * @param description The description of the task.
     * @return The newly created task.
     */
    public static Task createSubtask(Task parentTask, String name, String description) {
        return new Task(parentTask.parentPlan(), name, description);
    }

    /**
     * Create a new task.
     *
     * @param plan         The plan this activity belongs to.
     * @param name         The name of the activity.
     * @param description  The description of the activity.
     * @return The newly created activity.
     */
    public static Activity createActivity(Plan plan, String name, String description) {
        return new Activity(plan, name, description);
    }

}
