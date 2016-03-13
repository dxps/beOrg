package ro.visva.beorg.infra.repos;

/**
 * <br><br>
 * 2016-03-13 16:54 | visvadw | Creation time.
 */
public class RepositoryConnectorError {

    private String errorCode;

    private String errorMessage;

    public RepositoryConnectorError(final String errorCode, final String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /** Get the error code. */
    public String errorCode() {
        return errorCode;
    }

    /** Get the error message. */
    public String getErrorMessage() {
        return errorMessage;
    }

}
