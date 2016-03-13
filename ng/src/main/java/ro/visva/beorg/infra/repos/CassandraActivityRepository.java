package ro.visva.beorg.infra.repos;

import ro.visva.beorg.domain.repos.ActivityRepository;

import java.util.List;

/**
 * <br><br>
 * 2016-03-13 16:49 | visvadw | Creation time.
 */
public class CassandraActivityRepository implements ActivityRepository {

    @Override
    public boolean init(RepositoryConnector connector) {
        return false;
    }

    @Override
    public boolean isInited() {
        return false;
    }

    @Override
    public boolean hasErrors() {
        return false;
    }

    @Override
    public List<RepositoryConnectorError> errors() {
        return null;
    }

}
