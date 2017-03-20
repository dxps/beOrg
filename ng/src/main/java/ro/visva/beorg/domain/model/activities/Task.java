package ro.visva.beorg.domain.model.activities;

import ro.visva.beorg.domain.model.plans.Plan;
import ro.visva.beorg.domain.model.plans.Project;

import java.util.HashMap;
import java.util.Map;

/**
 * <br><br>
 * 2016-03-10 21:24 | visvadw | Creation time.
 */
public class Task extends WorkItem implements Comparable<Task> {

    private Plan parentPlan;

    private Task parentTask;

    private Map<String, Task> subtasks = new HashMap<>(1, 1);

    private Map<String, Activity> activities = new HashMap<>(1, 1);

    /** Create a new task. */
    public Task(Project parentPlan, String name) {
        super(WorkItemType.TASK_TYPE, name);
        this.parentPlan = parentPlan;
        this.parentPlan.addTask(this);
    }

    /** Create a new task. */
    public Task(Project parentPlan, String name, String description) {
        this(parentPlan, name);
        setDescription(description);
    }

    /** Create a new subtask. */
    public Task(Task parentTask, String name) {
        super(WorkItemType.TASK_TYPE, name);
        this.parentPlan = parentTask.parentPlan();
        this.parentTask = parentTask;
        this.parentTask.addSubtask(this);
    }

    /** Create a new subtask. */
    public Task(Task parentTask, String name, String description) {
        this(parentTask, name);
        setDescription(description);
    }


    /** Get the parent plan this task belongs to. */
    public Plan parentPlan() {
        return parentPlan;
    }

    /** Get the parent task, this subtask belongs to. */
    public Task parentTask() {
        return parentTask;
    }

    /** Set the parent task of this subtask. */
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

        int hashPrimeValue = 19;
        int hashCodeValue =
                +(57691 * hashPrimeValue)
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
