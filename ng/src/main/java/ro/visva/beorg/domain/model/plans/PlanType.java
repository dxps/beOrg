package ro.visva.beorg.domain.model.plans;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * <br><br>
 * 2016-03-12 18:06 | visvadw | Creation time.
 */
public enum PlanType {

    PLAN((byte) 0, "Plan"),
    INITIATIVE((byte) 1, "Initiative"),
    PROJECT((byte) 2, "Project");

    private byte id;
    private String name;

    private PlanType(byte id, String name) {
        this.id = id;
        this.name = name;
    }

    private static final Map<Byte, PlanType> reverseLookup = new HashMap<>(5);

    static {
        for (PlanType state : EnumSet.allOf(PlanType.class))
            reverseLookup.put(state.id(), state);
    }

    /** Get the PlanType by id. */
    public static PlanType get(byte id) {
        return reverseLookup.get(id);
    }

    /** Get the name of this PlanType. */
    public String getName() {
        // cannot use name() as being already used by Enum
        return name;
    }

    /** Get the id of this PlanType. */
    public byte id() {
        return id;
    }

}
