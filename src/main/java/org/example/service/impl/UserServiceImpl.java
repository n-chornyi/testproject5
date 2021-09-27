package org.example.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.dto.CreateUserDTO;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.exceprion.NotFoundException;
import org.example.mapper.UserMapper;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO save(CreateUserDTO user) {
        return userMapper.getDTO(userRepository.save(userMapper.parseDTO(user)));
    }

    @Override
    public List<UserDTO> getAll() {
        return userMapper.getList(userRepository.findAll());
    }

    @Override
    public UserDTO getById(int id) {
        UserDTO userDTO = userMapper.getDTO(userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User with id %s not found", id))));
        return userDTO;
    }

    @Override
    public void deleteById(int id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException(String.format("User with id %s not found", id));
        }
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDTO updateUser(UserDTO userDTO, int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Not user with IDs %s", id)));
        user = userMapper.update(userDTO, user);
        user.setId(id);
        UserDTO updatedUser = userMapper.getDTO(user);
        return updatedUser;
    }
}
