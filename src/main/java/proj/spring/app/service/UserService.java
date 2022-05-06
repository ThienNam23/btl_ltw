package proj.spring.app.service;

import proj.spring.app.entity.User;
import proj.spring.app.entity.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    /**
     * Save user into database then return user
     * @param user
     * @return user
     */
    User save(User user);

    /**
     * Add new user to db
     * @param user
     * @return
     */
    User addNewUser(User user);

    User findByUsername(String username);

    List<User> getUsers();

    User findById(UUID id);

    User toUser(UserDto userDto);

//    Boolean existsByUsername(String username);
}
