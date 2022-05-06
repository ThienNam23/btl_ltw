package proj.spring.app.service;

import proj.spring.app.entity.Role;
import proj.spring.app.entity.dto.RoleDto;

import java.util.List;

public interface RoleService {
    Role findByRoleName(String roleName);

    Role save(Role role);

    List<Role> getAll();
}
