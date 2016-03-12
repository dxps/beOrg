package ro.visva.beorg.domain.model.plans;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * <br><br>
 * 2016-03-12 21:46 | visvadw | Creation time.
 */
public enum PlanState {

    CREATED((byte) 0, "Created"),
    STARTED((byte) 1, "Started"),
    IN_PROGRESS((byte) 2, "In Progress"),
    DONE((byte) 3, "Done"),
    CANCELED((byte) 4, "Canceled"),
    POSTPONED((byte) 5, "Postponed");

    private byte id;
    private String name;

    private PlanState(byte id, String name) {
        this.id = id;
        this.name = name;
    }

    private static final Map<Byte, PlanType> reverseLookup = new HashMap<>(6);

    static {
        for (PlanType planType : EnumSet.allOf(PlanType.class))
            reverseLookup.put(planType.id(), planType);
    }

    /** Get the type by id. */
    public static PlanType get(byte id) {
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
