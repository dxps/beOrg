package ro.visva.beorg.infra.repos;

import java.util.List;

/**
 * <br><br>
 * 2016-03-13 16:51 | visvadw | Creation time.
 */
public interface RepositoryConnector {

    /** Get the identifier of this connector. */
    public String id();

    /** Is this connector initialized? */
    public boolean isInited();

    /** Does this connector have errors? */
    public boolean hasErrors();

    /** Get the errors this connector may have. */
    public List<RepositoryConnectorError> errors();

}
