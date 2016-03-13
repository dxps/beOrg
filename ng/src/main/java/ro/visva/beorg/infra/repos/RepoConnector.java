package ro.visva.beorg.infra.repos;

import java.util.List;

/**
 * <br><br>
 * 2016-03-13 16:51 | visvadw | Creation time.
 */
public interface RepoConnector {

    /** Is this connector initialized? */
    boolean isInited();

    /** Does this connector have errors? */
    boolean hasErrors();

    /** Get the errors this connector may have. */
    List<RepoConnectorError> errors();

}
