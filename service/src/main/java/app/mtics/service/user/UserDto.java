package app.mtics.service.user;

public class UserDto {
    private long id;
    private String firstName;
    private String lastName;

    public UserDto(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
