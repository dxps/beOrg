package ro.visva.beorg.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <br><br>
 * 2016-03-10 21:24 | visvadw | Creation time.
 */
public class Task extends Action implements Comparable<Task> {

    private String id;
    private String title;
    private String description;

    private List<Activity> activities;

    private int hashPrimeValue = 19;

    /** Create a new task. */
    public Task(String title) {
        super(title);
        this.activities = new ArrayList<>(0);
    }

    /** Create a new task. */
    public Task(String title, String description) {
        this(title);
        this.setDescription(description);
    }

    /** Add an activity to the task. */
    public Task addActivity(Activity activity) {
        if (activity != null) this.activities.add(activity);
        return this;
    }

    // ____________________________________________________

    @Override
    public int compareTo(Task task) {

        int diff = this.id().compareTo(task.id());

        if (diff == 0) {
            diff = this.title().compareTo(task.title());

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
            equalObjects = this.title().equals(typedObject.title()) &&
                    this.id().equals(typedObject.id()) &&
                    this.description().equals(typedObject.description());
        }

        return equalObjects;
    }

    @Override
    public int hashCode() {

        int hashCodeValue =
                +(57691 * this.hashPrimeValue)
                        + this.title().hashCode()
                        + this.description().hashCode()
                        + this.id().hashCode();

        return hashCodeValue;
    }

    @Override
    public String toString() {

        return String.format("{ title: '%s', description: '%s', id: '%s'}",
                this.title, this.description, this.id);
    }

}
