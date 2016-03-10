package ro.visva.beorg.domain.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * <br><br>
 * 2016-03-10 22:20 | visvadw | Creation time.
 */
public enum ActionState {

    CREATED("Created"),
    STARTED("Started"),
    IN_PROGRESS("In Progress"),
    FINISHED("Finished"),
    CANCELED("Canceled"),
    POSTPONED("Postponed");

    private String name;

    private ActionState(String name) {
        this.name = name;
    }

    private static final Map<String, ActionState> reverseLookup = new HashMap<>(5);

    static {
        for (ActionState actionState : EnumSet.allOf(ActionState.class))
            reverseLookup.put(actionState.getName(), actionState);
    }

    public static ActionState get(String name) {
        return reverseLookup.get(name);
    }

    public String getName() {
        return name;
    }

}
