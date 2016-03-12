package ro.visva.beorg.domain.model.activities;

import ro.visva.beorg.domain.model.plans.Project;

/**
 * <br><br>
 * 2016-03-10 22:00 | visvadw | Creation time.
 */
public class Activity extends WorkItem {

    /** the parent task to whom it belongs */
    private Task parentTask;

    /** the parent project to whom it belongs */
    private Project parentProject;

    /** Create a new activity. */
    public Activity(Task parentTask, String name) {
        super(WorkItemType.ACTIVITY, name);
        this.parentTask = parentTask;
    }

    /** Create a new activity. */
    public Activity(Task parentTask, String name, String description) {
        this(parentTask, name);
        setDescription(description);
    }

    /** Create a new activity. */
    public Activity(Project parentProject, String name) {
        super(WorkItemType.ACTIVITY, name);
        this.parentProject = parentProject;
    }

    /** Create a new activity. */
    public Activity(Project parentProject, String name, String description) {
        this(parentProject, name);
        setDescription(description);
    }

    /** Get the parent project this activity belongs to, if any. */
    public Project parentProject() {
        return parentProject;
    }

    /** Get the parent task this activity belongs to, if any. */
    public Task parentTask() {
        return parentTask;
    }

}
