package ro.visva.beorg.domain.model.activities;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * <br><br>
 * 2016-03-12 20:23 | visvadw | Creation time.
 */
public enum WorkItemType {

    TASK_TYPE((byte) 0, "Task"),
    ACTIVITY_TYPE((byte) 1, "Activity");

    private byte id;
    private String name;

    private WorkItemType(byte id, String name) {
        this.id = id;
        this.name = name;
    }

    private static final Map<Byte, WorkItemType> reverseLookup = new HashMap<>(2);

    static {
        for (WorkItemType type : EnumSet.allOf(WorkItemType.class))
            reverseLookup.put(type.id(), type);
    }

    /** Get the state by id. */
    public static WorkItemType get(byte id) {
        return reverseLookup.get(id);
    }

    /** Get the id of this type. */
    public byte id() {
        return id;
    }

    /** Get the name of this type. */
    public String getName() {
        // cannot use name() as being already used by Enum
        return name;
    }

}
