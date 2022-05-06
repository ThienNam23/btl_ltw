package proj.spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.spring.app.entity.Role;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepo extends JpaRepository<Role, UUID> {
    Optional<Role> findByRoleName(String roleName);
}

