package app.mtics.domain.authentication.security;

public enum Role {
    SYSADMIN(Values.SYSADMIN),
    MEMBER(Values.MEMBER),
    MANAGER(Values.MANAGER);

    private String role;

    Role(String role) {
        this.role = role;
    }

    public static class Values {
        public static final String SYSADMIN = "sysadmin";
        public static final String MEMBER = "member";
        public static final String MANAGER = "manager";
    }

    public String getRole() {
        return role;
    }
}
