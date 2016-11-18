package ro.visva.beorg.domain.model;

import java.io.Serializable;

/**
 * <br><br>
 * 2016-03-10 20:44 | visvadw | Creation time.
 */
public class User implements Comparable<User>, Serializable {

    private String id;
    private String name;
    private String email;
    private String firstName;
    private String lastName;

    private int hashPrimeValue = 17;

    public User(String name, String email, String firstName, String lastName) {
        this.id = IdentityFactory.createId();
        this.setName(name).setEmail(email).setFirstName(firstName).setLastName(lastName);
    }

    public String id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public String email() {
        return this.email;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public int compareTo(User user) {

        int diff = this.id().compareTo(user.id());

        if (diff == 0) {
            diff = this.email().compareTo(user.email());

            if (diff == 0) {
                diff = this.name().compareTo(user.name());
            }
        }

        return diff;
    }

    // ____________________________________________________

    @Override
    public boolean equals(Object anObject) {

        boolean equalObjects = false;
        if (anObject != null && this.getClass() == anObject.getClass()) {
            User typedObject = (User) anObject;
            equalObjects = this.email().equals(typedObject.email()) &&
                    this.id().equals(typedObject.id()) &&
                    this.name().equals(typedObject.name());
        }

        return equalObjects;
    }

    @Override
    public int hashCode() {

        int hashCodeValue =
                +(57691 * this.hashPrimeValue)
                        + this.email().hashCode()
                        + this.id().hashCode()
                        + this.name().hashCode();

        return hashCodeValue;
    }

    @Override
    public String toString() {

        return String.format("{ name: '%s', firstName: '%s', lastName: '%s', emailAddress: '%s', id: '%s'}",
                this.name, this.firstName, this.lastName, this.email, this.id);
    }

}
