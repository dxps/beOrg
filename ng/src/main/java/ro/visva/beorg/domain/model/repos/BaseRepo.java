package ro.visva.beorg.domain.model.repos;

import ro.visva.beorg.infra.repos.RepoConnector;
import ro.visva.beorg.infra.repos.RepoConnectorError;

import java.util.List;

/**
 * Common repository operations.
 * <br><br>
 * 2016-03-13 16:50 | visvadw | Creation time.
 */
public interface BaseRepo {

    /** Initialize the repository. */
    public boolean init(RepoConnector connector);

    /** Is this repository initialized? */
    public boolean isInited();

    /** Does this repository have errors? */
    public boolean hasErrors();

    /** Get the errors this repository may have. */
    public List<RepoConnectorError> errors();

}
