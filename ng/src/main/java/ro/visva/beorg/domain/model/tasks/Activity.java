package ro.visva.beorg.domain.model.tasks;

import ro.visva.beorg.domain.model.plans.Plan;

/**
 * An activity represents a simple action or a note about something that happened.
 * It may be associated with a Plan or a Task.
 * <br><br>
 * 2016-03-10 22:00 | visvadw | Creation time.
 */
public class Activity extends WorkItem {

    /** the parent task to whom it belongs */
    private Task parentTask;

    /** the parent project to whom it belongs */
    private Plan parentPlan;

    /** Create a new activity. */
    public Activity(Task parentTask, String name) {
        super(WorkItemType.ACTIVITY_TYPE, name);
        this.parentTask = parentTask;
        this.parentTask.addActivity(this);
    }

    /** Create a new activity. */
    public Activity(Task parentTask, String name, String description) {
        this(parentTask, name);
        setDescription(description);
    }

    /** Create a new activity. */
    public Activity(Plan parentPlan, String name) {
        super(WorkItemType.ACTIVITY_TYPE, name);
        this.parentPlan = parentPlan;
        this.parentPlan.addActivity(this);
    }

    /** Create a new activity. */
    public Activity(Plan parentPlan, String name, String description) {
        this(parentPlan, name);
        setDescription(description);
    }

    /** Get the parent project this activity belongs to, if any. */
    public Plan parentProject() {
        return parentPlan;
    }

    /** Get the parent task this activity belongs to, if any. */
    public Task parentTask() {
        return parentTask;
    }

}
