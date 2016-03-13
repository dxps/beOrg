package ro.visva.beorg.domain;

import java.util.UUID;

/**
 * <br><br>
 * 2016-03-10 20:54 | visvadw | Creation time.
 */
public class IdentityFactory {

    public static String createId() {
        return UUID.randomUUID().toString();
    }

}
