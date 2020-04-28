package app.mtics.service.user;

import app.mtics.domain.user.Sysadmin;
import app.mtics.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName());
    }

    public User toUser(CreateUserDto createUserDto) {
        return new Sysadmin(createUserDto.getFirstName(), createUserDto.getLastName());
    }

    public Collection<UserDto> toDto(Collection <User> userCollection) {
        return userCollection.stream().map(this::toDto).collect(Collectors.toList());
    }
}
