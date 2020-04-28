package app.mtics.domain.authentication;

import org.springframework.data.repository.CrudRepository;

public interface AuthenticationRepository extends CrudRepository<Authentication, Long> {
    Authentication findByEmail(String email);
}
