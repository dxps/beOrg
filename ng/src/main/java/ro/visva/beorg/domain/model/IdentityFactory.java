package ro.visva.beorg.domain.model;

import java.util.UUID;

/**
 * <br><br>
 * 2016-03-10 20:54 | visvadw | Creation time.
 */
public class IdentityFactory {

    /** 
     * Create a new identifier.
     * @return A unique identifier (UUID).
     * */
    public static String createId() {
        return UUID.randomUUID().toString();
    }

}
