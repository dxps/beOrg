package ro.visva.beorg.domain.model.plans;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import ro.visva.beorg.domain.model.tasks.Activity;
import ro.visva.beorg.domain.model.tasks.Task;

import java.util.HashMap;
import java.util.Map;

/**
 * <br><br>
 * 2016-03-12 21:41 | visvadw | Creation time.
 */
public abstract class Plan {

    private String id;
    private String name;
    private String description;

    private PlanType type;
    private PlanState state;

    /** the tasks that belong to this plan */
    private Map<String, Task> tasks = new HashMap<>(1,1);

    /** the activities recorded to this plan */
    private Map<String, Activity> activities = new HashMap<>(0,1);

    private DateTime beginTime;
    private DateTime endTime;

    /** Create a new plan. */
    public Plan(PlanType type, String name, String description) {
        this(type, name);
        this.description = description;
    }

    /** Create a new plan. */
    public Plan(PlanType type, String name) {
        this.type = type;
        this.name = name;
    }

    /** Add a task to the plan. */
    public void addTask(Task task) {
        if (task == null) return;
        tasks.put(task.id(), task);
    }

    /** Remove a task from the plan. */
    public void removeTask(Task task) {
        if (task == null) return;
        tasks.remove(task.id(), task);
    }

    /** Add an activity to the plan. */
    public void addActivity(Activity activity) {
        if (activity == null) return;
        activities.put(activity.id(), activity);
    }

    /** Remove an activity from the plan. */
    public void removeActivity(Activity activity) {
        if (activity == null) return;
        activities.remove(activity.id(), activity);
    }

    /** Get the identifier. */
    public String id() {
        return id;
    }

    /** Get the name. */
    public String name() {
        return name;
    }

    /** Get the description. */
    public String description() {
        return description;
    }

    public PlanState state() {
        return state;
    }

    /** Get the beginning time. */
    public DateTime beginTime() {
        return beginTime;
    }

    /** Get the ending time. */
    public DateTime endTime() {
        return endTime;
    }

    /**
     * Get the duration of this work item in seconds.<br>
     * <i>Note:</i> It returns -1 if begin or end times are not defined.
     */
    public long durationInSeconds() {
        if ((beginTime == null) || (endTime == null)) return -1;
        return new Duration(beginTime, endTime).getStandardSeconds();
    }

    /**
     * Get the duration of this work item in minutes.<br>
     * <i>Note:</i> It returns -1 if begin or end times are not defined.
     */
    public long durationInMinutes() {
        if ((beginTime == null) || (endTime == null)) return -1;
        return new Duration(beginTime, endTime).getStandardMinutes();
    }

    /**
     * Get the duration of this work item in hours.<br>
     * <i>Note:</i> It returns -1 if begin or end times are not defined.
     */
    public long durationInHours() {
        if ((beginTime == null) || (endTime == null)) return -1;
        return new Duration(beginTime, endTime).getStandardHours();
    }

    /**
     * Get the duration of this work item in days.<br>
     * <i>Note:</i> It returns -1 if begin or end times are not defined.
     */
    public long durationInDays() {
        if ((beginTime == null) || (endTime == null)) return -1;
        return new Duration(beginTime, endTime).getStandardDays();
    }

    /** Set the description. */
    public void setDescription(String description) {
        this.description = description;
    }

    /** Set the beginning time. */
    public void setBeginTime(DateTime beginTime) {
        this.beginTime = beginTime;
    }

    /** Set the ending time. */
    public void setEndTime(DateTime beginTime) {
        this.endTime = endTime;
    }

}
