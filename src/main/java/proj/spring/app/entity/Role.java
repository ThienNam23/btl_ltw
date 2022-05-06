package proj.spring.app.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "app_Role")
@Table(name = "app_role")
public class Role extends StandardEntity {

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    public RoleNameEnum getRoleName() {
        return RoleNameEnum.fromName(roleName);
    }

    public void setRoleName(RoleNameEnum roleName) {
        this.roleName = roleName == null ? null : roleName.getName();
    }
}
