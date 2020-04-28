package app.mtics.service.user;

import app.mtics.domain.authentication.Authentication;
import app.mtics.domain.authentication.AuthenticationRepository;
import app.mtics.domain.exceptions.EmailAlreadyRegisteredException;
import app.mtics.domain.user.User;
import app.mtics.domain.user.UserRepository;
import app.mtics.service.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    private UserRepository userRepository;
    private AuthenticationRepository authenticationRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, AuthenticationRepository authenticationRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.authenticationRepository = authenticationRepository;
    }

    public UserDto register(CreateUserDto createUserDto) {
        Validation.isValidEmailAddress(createUserDto.getEmail());
        isEmailAvailable(createUserDto.getEmail());
        User user = userMapper.toUser(createUserDto);
        UserDto userDto = userMapper.toDto(userRepository.save(user));
        authenticationRepository.save(new Authentication(createUserDto.getPassword(),createUserDto.getEmail(), user));
        return userDto;
    }

    public Collection<UserDto> getAllMembers() {
        return userMapper.toDto(userRepository.findAll());
    }

    private void isEmailAvailable(String email) throws EmailAlreadyRegisteredException {
        if (authenticationRepository.findByEmail(email) != null) {
            throw new EmailAlreadyRegisteredException(email);
        }
    }

}
