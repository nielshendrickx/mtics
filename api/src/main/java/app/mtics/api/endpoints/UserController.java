package app.mtics.api.endpoints;

import app.mtics.service.security.Views;
import app.mtics.service.user.CreateUserDto;
import app.mtics.service.user.UserDto;
import app.mtics.service.user.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping(path = UserController.USER_RESOURCE_PATH)
public class UserController {
    public static final String USER_RESOURCE_PATH = "/user";
    private final Logger loggerUser = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @JsonView(Views.Public.class)
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Register as a member", notes = "Register as a new member to Mtics!" , response = UserDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto register(@RequestBody CreateUserDto newUser) throws IOException {
        loggerUser.info("Creating a new user");
        return userService.register(newUser);
    }

    @PreAuthorize("hasAuthority('VIEW_MEMBERS')")
    @JsonView(Views.Manager.class)
    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Get all registered members", notes = "A list of all the registered members will be returned", response = UserDto.class)
    @ResponseStatus(HttpStatus.OK)
    public Collection<UserDto> getAllMembers() {
        loggerUser.info("Returning all members");
        return userService.getAllMembers();
    }
}
