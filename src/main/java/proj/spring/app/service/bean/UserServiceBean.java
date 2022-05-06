package proj.spring.app.service.bean;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import proj.spring.app.entity.Role;
import proj.spring.app.entity.RoleNameEnum;
import proj.spring.app.entity.User;
import proj.spring.app.entity.dto.UserDto;
import proj.spring.app.repository.UserRepo;
import proj.spring.app.service.RoleService;
import proj.spring.app.service.UserService;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceBean implements UserService {
    private final UserRepo userRepo;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User addNewUser(User user) {
        Role roleUser = roleService.findByRoleName(RoleNameEnum.USER.getName());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRoles() == null) {
            user.setRoles(new LinkedHashSet<>());
        }
        user.getRoles().add(roleUser);
        return userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findById(UUID id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User toUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setActive(true);

        return user;
    }

//    @Override
//    public Boolean existsByUsername(String username) {
//        return userRepo.existsByUsername(username);
//    }

//    @Override
//    public Boolean existsByEmail(String email) {
//        return userRepo.existsByEmail(email);
//    }
}
