package ro.visva.beorg.domain.activities;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import ro.visva.beorg.domain.IdentityFactory;

/**
 * WorkItem is the base of any Activity or Task.
 * <br><br>
 * 2016-03-12 18:34 | visvadw | Creation time.
 */
public abstract class WorkItem {

    private String id;
    private String name;
    private String description;

    private WorkItemType type;
    private WorkItemState state;

    private DateTime beginTime;
    private DateTime endTime;

    protected WorkItem(WorkItemType type, String name) {
        this.id = IdentityFactory.createId();
        this.type = type;
        this.name = name;
        this.state = WorkItemState.CREATED;
    }

    protected WorkItem(WorkItemType type, String name, String description) {
        this(type, name);
        this.description = description;
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

    public WorkItemState state() {
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
