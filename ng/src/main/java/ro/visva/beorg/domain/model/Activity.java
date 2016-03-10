package ro.visva.beorg.domain.model;

/**
 * <br><br>
 * 2016-03-10 22:00 | visvadw | Creation time.
 */
public class Activity extends Action {

    /** the task to whom it belongs */
    private Task task;

    /** Create a new activity. */
    public Activity(Task task, String title) {
        super(title);
    }

    /** Get the task to whom this activity belongs. */
    public Task task() {
        return task;
    }

    /** Set the task to whom this activity belongs. */
    public boolean setTask(Task task) {
        this.task = task;
        return true;
    }

}
