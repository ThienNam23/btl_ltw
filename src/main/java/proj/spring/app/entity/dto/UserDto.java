package proj.spring.app.entity.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String gender;
    private String email;
    private String phoneNumber;
    private String description;
    private Boolean active;
}
