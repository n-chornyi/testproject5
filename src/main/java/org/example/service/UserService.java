package org.example.service;

import java.util.List;
import org.example.dto.CreateUserDTO;
import org.example.dto.UserDTO;
import org.example.entity.User;

public interface UserService {

    UserDTO save(CreateUserDTO user);

    List<UserDTO> getAll();

    UserDTO getById(int id);

    void deleteById(int id);

    UserDTO updateUser(UserDTO user, int id);
}
