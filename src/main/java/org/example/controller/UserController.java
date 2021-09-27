package org.example.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.example.dto.CreateUserDTO;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @GetMapping
    @ApiOperation("Get all users")
    public List<UserDTO> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get user by id")
    public UserDTO userById(@PathVariable(name = "id") @NotNull int id) {
        return userService.getById(id);
    }

    @PostMapping
    @ApiOperation("Add new user")
    public UserDTO addUser(@RequestBody @Valid @NotNull CreateUserDTO createUserDTO) {
        return userService.save(createUserDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete user by id")
    public void deleteUser(@PathVariable(name = "id") @NotNull int id) {
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update user")
    public UserDTO updateUser(@PathVariable(name = "id") @NotNull int id,
                           @RequestBody @Valid @NotNull UserDTO userDTO) {
        return userService.updateUser(userDTO, id);
    }
}
