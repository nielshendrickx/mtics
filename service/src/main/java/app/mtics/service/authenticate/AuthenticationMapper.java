package app.mtics.service.authenticate;

import app.mtics.domain.authentication.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationMapper {
    public AuthenticationDto toDto(Authentication authentication) {
        return new AuthenticationDto(authentication.getEmail(), authentication.getUser().getRole(), authentication.getPassword());
    }
}
