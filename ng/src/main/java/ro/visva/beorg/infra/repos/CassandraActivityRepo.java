package ro.visva.beorg.infra.repos;

import ro.visva.beorg.domain.model.tasks.Activity;
import ro.visva.beorg.domain.model.tasks.Task;
import ro.visva.beorg.domain.model.repos.ActivityRepo;

import java.util.List;

/**
 * <br><br>
 * 2016-03-13 16:49 | visvadw | Creation time.
 */
public class CassandraActivityRepo implements ActivityRepo {

    private static CassandraActivityRepo instance = new CassandraActivityRepo();

    private CassandraRepoConnector connector;

    private CassandraActivityRepo() {
        // private c'tor as being a singleton
    }

    /** Get the instance of this connector */
    public static CassandraActivityRepo getInstance() {
        return instance;
    }

    public boolean add(Activity activity) {
        return false;
    }

    public boolean update(Activity activity) {
        return false;
    }

    public boolean delete(Activity activity) {
        return false;
    }

    public List<Activity> listByTask(Task task) {
        return null;
    }

    public boolean init(RepoConnector connector) {
        if ( (connector != null) && (connector instanceof CassandraRepoConnector) ) {
            this.connector = (CassandraRepoConnector) connector;
            return this.connector.isInited();
        }
        return false;
    }

    public boolean isInited() {
        return this.connector.isInited();
    }

    public boolean hasErrors() {
        return this.connector.hasErrors();
    }

    public List<RepoConnectorError> errors() {
        return this.connector.errors();
    }

}
