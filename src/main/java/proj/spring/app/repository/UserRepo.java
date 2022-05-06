package proj.spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.spring.app.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}
