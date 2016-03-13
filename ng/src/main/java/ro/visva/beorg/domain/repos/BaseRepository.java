package ro.visva.beorg.domain.repos;

import ro.visva.beorg.infra.repos.RepositoryConnector;
import ro.visva.beorg.infra.repos.RepositoryConnectorError;

import java.util.List;

/**
 * <br><br>
 * 2016-03-13 16:50 | visvadw | Creation time.
 */
public interface BaseRepository {

    /** Initialize the repository. */
    public boolean init(RepositoryConnector connector);

    /** Is this repository initialized? */
    public boolean isInited();

    /** Does this repository have errors? */
    public boolean hasErrors();

    /** Get the errors this repository may have. */
    public List<RepositoryConnectorError> errors();

}
