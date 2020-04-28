package app.mtics.service.authenticate;

import app.mtics.domain.authentication.Authentication;
import app.mtics.domain.authentication.AuthenticationRepository;
import app.mtics.domain.exceptions.AuthenticationFailedException;
import app.mtics.service.security.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private AuthenticationRepository authenticationRepository;
    private AuthenticationMapper authenticationMapper;

    @Autowired

    public AuthenticationService(AuthenticationRepository authenticationRepository, AuthenticationMapper authenticationMapper) {
        this.authenticationRepository = authenticationRepository;
        this.authenticationMapper = authenticationMapper;
    }

    public AuthenticationDto authenticate(String email, String password) {
        Authentication authentication = findAuthenticationByEmail(email);
        if(!Hash.verifyHash(password, authentication.getPassword())) {
            throw new AuthenticationFailedException();
        }
        return authenticationMapper.toDto(authentication);
    }

    private Authentication findAuthenticationByEmail(String email) {
        if(authenticationRepository.findByEmail(email) == null) {
            throw new AuthenticationFailedException();
        }
        return authenticationRepository.findByEmail(email);
    }
}
