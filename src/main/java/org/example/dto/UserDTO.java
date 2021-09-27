package org.example.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDTO {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private String login;
    private String password;
    private String about;
    private String address;
}
