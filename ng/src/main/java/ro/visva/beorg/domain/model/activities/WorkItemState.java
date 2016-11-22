package ro.visva.beorg.domain.model.activities;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * <br><br>
 * 2016-03-10 22:20 | visvadw | Creation time.
 */
public enum WorkItemState {

    /** WorkItem is created. */
    CREATED((byte) 0, "Created"),

    /** WorkItem is assigned to a user or group. */
    ASSIGNED((byte) 1, "Assigned"),

    /** WorkItem has been started. */
    STARTED((byte) 2, "Started"),

    /** WorkItem is in progress. */
    IN_PROGRESS((byte) 3, "In Progress"),

    /** WorkItem is done (complete). */
    DONE((byte) 4, "Done"),

    /** WorkItem is canceled. */
    CANCELED((byte) 5, "Canceled"),

    /** WorkItem is postponed. */
    POSTPONED((byte) 6, "Postponed");

    private byte id;
    private String name;

    private WorkItemState(byte id, String name) {
        this.id = id;
        this.name = name;
    }

    private static final Map<Byte, WorkItemState> reverseLookup = new HashMap<>(7);

    static {
        for (WorkItemState workItemState : EnumSet.allOf(WorkItemState.class))
            reverseLookup.put(workItemState.id(), workItemState);
    }

    /** Get the state by id. */
    public static WorkItemState get(byte id) {
        return reverseLookup.get(id);
    }

    /** Get the name of the state. */
    public String getName() {
        // cannot use name() as being already used by Enum
        return name;
    }

    /** Get the id of the state. */
    public byte id() {
        return id;
    }

}
