package ro.visva.beorg.domain.model;

import org.joda.time.DateTime;
import ro.visva.beorg.domain.model.tasks.WorkItemState;

/**
 * An event is the basic element describing something that happened.<br/>
 * It can be any change that happened to a task, a new activity, and so on.
 * <br/><br/>
 * 2016-03-10 22:06 | visvadw | Creation time.
 */
public class Event {

    private String id;
    private String title;
    private String description;
    private WorkItemState state;
    private DateTime eventTime;

    public Event(String title) {
        this.id = IdentityFactory.createId();
        this.setTitle(title);
        this.state = WorkItemState.CREATED;
    }

    public Event(String title, String description) {
        this(title);
        this.setDescription(description);
    }

    public String id() {
        return this.id;
    }

    public String title() {
        return this.title;
    }

    public String description() {
        return this.description;
    }

    public DateTime eventTime() {
        return eventTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(WorkItemState state) {
        this.state = state;
    }

    public void setEventTime(DateTime eventTime) {
        this.eventTime = eventTime;
    }

}
