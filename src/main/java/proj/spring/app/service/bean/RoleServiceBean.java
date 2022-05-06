package proj.spring.app.service.bean;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proj.spring.app.entity.Role;
import proj.spring.app.entity.dto.RoleDto;
import proj.spring.app.repository.RoleRepo;
import proj.spring.app.service.RoleService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceBean implements RoleService {

    private final RoleRepo roleRepo;

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepo.findByRoleName(roleName).orElse(null);
    }

    @Override
    public Role save(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public List<Role> getAll() {
        return roleRepo.findAll();
    }
}
