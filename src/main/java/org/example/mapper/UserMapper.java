package org.example.mapper;

import java.util.List;
import org.example.dto.CreateUserDTO;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO getDTO(User user);

    User parseDTO(UserDTO userDTO);

    User parseDTO(CreateUserDTO createUserDTO);

    List<UserDTO> getList(List<User> users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User update(UserDTO userDTO, @MappingTarget User user);
}
