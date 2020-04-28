package app.mtics.domain.user;

import app.mtics.domain.authentication.security.Role;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = Role.Values.SYSADMIN)
public class Sysadmin extends User {

    public Sysadmin() {
    }

    public Sysadmin(String firstName, String lastName) {
        super(firstName,lastName);
    }
    public Role getRole() {
        return Role.SYSADMIN;
    }
}
