package ro.visva.beorg.domain.model;

/** An action is the foundation of anything that may happen in the context.<br>
 * This can be a task, an activity or an event.
 * <br><br>
 * 2016-03-10 22:06 | visvadw | Creation time.
 */
public abstract class Action {

    private String id;
    private String title;
    private String description;
    private ActionState state;

    public Action(String title) {
        this.id = IdentityFactory.createId();
        this.setTitle(title);
        this.state = ActionState.CREATED;
    }

    public Action(String title, String description) {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(ActionState state) {
        this.state = state;
    }
}
