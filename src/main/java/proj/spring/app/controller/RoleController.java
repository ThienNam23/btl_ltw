package proj.spring.app.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proj.spring.app.entity.Role;
import proj.spring.app.entity.dto.RoleDto;
import proj.spring.app.service.RoleService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAll();
        return new ResponseEntity<>(roles, HttpStatus.CREATED);
    }
}
