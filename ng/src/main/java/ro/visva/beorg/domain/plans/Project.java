package ro.visva.beorg.domain.plans;

/**
 * TODO: Is it really needed? A Plan is not enough?
 * <br><br>
 * 2016-03-12 21:55 | visvadw | Creation time.
 */
public class Project extends Plan {

    public Project(PlanType type, String name) {
        super(type, name);
    }

    public Project(PlanType type, String name, String description) {
        super(type, name, description);
    }

}
