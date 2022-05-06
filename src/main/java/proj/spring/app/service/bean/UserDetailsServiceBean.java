package proj.spring.app.service.bean;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import proj.spring.app.entity.MyUserDetails;
import proj.spring.app.repository.UserRepo;

import org.springframework.transaction.annotation.Transactional;
import proj.spring.app.entity.User;

@Service
@AllArgsConstructor
public class UserDetailsServiceBean implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found!"));
        return new MyUserDetails(user);
    }
}