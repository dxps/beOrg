package ro.visva.beorg.domain.model.plans;

/**
 * <br/><br/>
 * ________________________________________________ <br/>
 * 2016-12-26 | ilema | Creation.
 */
public class Project extends Plan {

    /** Create a new project. */
    public Project(String name) {
        super(PlanType.PLAN, name);
    }

    /** Create a new project. */
    public Project(String name, String description) {
        super(PlanType.PLAN, name, description);
    }
    
}
