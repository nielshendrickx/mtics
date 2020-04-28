package app.mtics.service.user;

import app.mtics.service.security.Hash;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    @JsonCreator
    public CreateUserDto(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("password") String password, @JsonProperty("email") String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = Hash.hash(password);
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
