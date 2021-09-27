package org.example.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CreateUserDTO {

    @NotBlank(message = "First name shouldn't be not null")
    @Size(min = 3, message = "First name shouldn't be shorted than {min}")
    private String firstName;
    @NotBlank(message = "Last name shouldn't be not null")
    @Size(min = 3, message = "Last name shouldn't be shorted than {min}")
    private String lastName;
    private LocalDateTime birthday;
    @NotBlank(message = "Login should be not null")
    @Size(min = 3, message = "Login shouldn't be shorted than {min}")
    private String login;
    @NotBlank(message = "Password shouldn't be not null")
    @Size(min = 3, message = "Password shouldn't be shorted than {min}")
    private String password;
    private String about;
    private String address;
}
