package proj.spring.app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import proj.spring.app.entity.User;
import proj.spring.app.entity.dto.UserDto;
import proj.spring.app.service.UserService;

@Controller
@AllArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("userDto") UserDto userDto) {
        User user = userService.toUser(userDto);
        userService.addNewUser(user);
        return "redirect:/login";
    }
}
