package ro.visva.beorg.domain.model.activities;

/**
 * <br><br>
 * 2016-03-10 22:00 | visvadw | Creation time.
 */
public class Activity extends WorkItem {

    /**
     * the parent (task or plan) to whom it belongs
     */
    private WorkItem parent;

    /** Create a new activity. */
    public Activity(WorkItem parent, String name) {
        super(WorkItemType.ACTIVITY, name);
        this.parent = parent;
    }

    /** Create a new activity. */
    public Activity(WorkItem parent, String name, String description) {
        this(parent, name);
        this.setDescription(description);
    }


    /** Get the parent (task or plan) to whom it belongs. */
    public WorkItem parent() {
        return parent;
    }

}
