package ro.visva.beorg.infra.repos;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.AuthenticationException;
import com.datastax.driver.core.exceptions.NoHostAvailableException;
import ro.visva.beorg.utils.Utils;

import java.util.*;

/**
 * <br><br>
 * 2016-03-13 17:12 | visvadw | Creation time.
 */
public class CassandraRepoConnector implements RepoConnector {

    private static CassandraRepoConnector instance = new CassandraRepoConnector();;

    private Cluster cluster;

    private Session session;

    private boolean inited = false;

    private Map<String, RepoConnectorError> errors = new HashMap<String, RepoConnectorError>(1, 1);


    private CassandraRepoConnector() {
        // private c'tor as being a singleton
    }

    /** Get the instance of this connector */
    public static CassandraRepoConnector getInstance() {
        return instance;
    }

    /**
     * Connect to Cassandra Cluster using the specified node IP address and port number.
     *
     * @param node Cluster node IP address.
     * @param port Port of cluster host.
     */
    public void connect(final String node, final int port, final String username, final String password) {

        this.cluster = Cluster.builder().addContactPoint(node).withPort(port).withCredentials(username, password).build();
        try {
            final Metadata metadata = cluster.getMetadata();
            // out.printf("Connected to cluster: %s\n", metadata.getClusterName());
            // for (final Host host : metadata.getAllHosts()) {
            //     out.printf("Datacenter: %s; Host: %s; Rack: %s\n", host.getDatacenter(), host.getAddress(), host.getRack());
            // }
            session = cluster.connect();
            inited = true;
        } catch (NoHostAvailableException e) {
            RepoConnectorError error = new RepoConnectorError(null, e.getMessage());
            errors.put(error.errorCode(), error);
            inited = false;
        } catch (AuthenticationException e) {
            RepoConnectorError error = new RepoConnectorError(null, e.getMessage());
            errors.put(error.errorCode(), error);
            inited = false;
        } catch (IllegalStateException e) {
            RepoConnectorError error = new RepoConnectorError(null, e.getMessage());
            errors.put(error.errorCode(), error);
            inited = false;
        }
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        cluster.close();
    }

    public boolean isInited() {
        return inited;
    }

    public boolean hasErrors() {
        return (errors.size() > 0);
    }

    public List<RepoConnectorError> errors() {
        List errorsList = new ArrayList(errors.size());
        Collection<RepoConnectorError> errs = errors.values();
        for (RepoConnectorError err : errs)
            errorsList.add(err);
        return errorsList;
    }

    @Override
    public String toString() {
        return String.format("{ cluster=%s, session=%s, inited=%s, errors=%s }",
                cluster, session, inited, Utils.printerFriendlyMap(errors));
    }

}
