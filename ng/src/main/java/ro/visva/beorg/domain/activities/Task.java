package ro.visva.beorg.domain.activities;

import ro.visva.beorg.domain.plans.Project;

import java.util.HashMap;
import java.util.Map;

/**
 * <br><br>
 * 2016-03-10 21:24 | visvadw | Creation time.
 */
public class Task extends WorkItem implements Comparable<Task> {

    private Project project;

    private Task parentTask;

    private Map<String, Task> subtasks = new HashMap<>(1, 1);

    private Map<String, Activity> activities = new HashMap<>(1, 1);

    private int hashPrimeValue = 19;

    /** Create a new task. */
    public Task(Project project, String name) {
        super(WorkItemType.TASK, name);
        this.project = project;
    }

    /** Create a new task. */
    public Task(Project project, String name, String description) {
        this(project, name);
        setDescription(description);
    }

    /** Create a new task. */
    public Task(Task parentTask, String name) {
        super(WorkItemType.TASK, name);
        this.project = parentTask.project();
        this.parentTask = parentTask;
    }

    /** Create a new task. */
    public Task(Task parentTask, String name, String description) {
        this(parentTask, name);
        setDescription(description);
    }


    /** Get the project this task belongs to. */
    public Project project() {
        return project;
    }

    /** Get the parent task, in case of a subtask. */
    public Task parentTask() {
        return parentTask;
    }

    /** Set the parent task, in case of a subtask. */
    public Task setParentTask(Task parentTask) {
        if (parentTask != null)  this.parentTask = parentTask;
        return this;
    }

    /** Add an activity to this task. */
    public Task addActivity(Activity activity) {
        if (activity != null) this.activities.put(activity.id(), activity);
        return this;
    }

    /** Remove an activity from this task. */
    public Task removeActivity(Activity activity) {
        if (activity != null) this.activities.remove(activity.id());
        return this;
    }

    /** Add a subtask to this task. */
    public Task addSubtask(Task task) {
        if (task != null) {
            this.subtasks.put(task.id(), task);
            task.setParentTask(this);
        }
        return this;
    }

    /** Remove a subtask from this task. */
    public Task removeSubtask(Task task) {
        if (task != null) this.subtasks.remove(task.id());
        return this;
    }

    // ____________________________________________________

    @Override
    public int compareTo(Task task) {

        int diff = this.id().compareTo(task.id());

        if (diff == 0) {
            diff = this.name().compareTo(task.name());

            if (diff == 0) {
                diff = this.description().compareTo(task.description());
            }
        }

        return diff;
    }

    @Override
    public boolean equals(Object anObject) {

        boolean equalObjects = false;
        if (anObject != null && this.getClass() == anObject.getClass()) {
            Task typedObject = (Task) anObject;
            equalObjects = this.name().equals(typedObject.name()) &&
                    this.id().equals(typedObject.id()) &&
                    this.description().equals(typedObject.description());
        }

        return equalObjects;
    }

    @Override
    public int hashCode() {

        int hashCodeValue =
                +(57691 * this.hashPrimeValue)
                        + this.name().hashCode()
                        + this.description().hashCode()
                        + this.id().hashCode();

        return hashCodeValue;
    }

    @Override
    public String toString() {

        return String.format("{ title: '%s', description: '%s', id: '%s'}",
                this.name(), this.description(), this.id());
    }

}