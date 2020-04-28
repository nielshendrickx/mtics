package app.mtics.service.authenticate;

import app.mtics.domain.authentication.security.Role;

public class AuthenticationDto {
    private String email;
    private Role role;
    private String password;

    public AuthenticationDto(String email, Role role, String password) {
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
