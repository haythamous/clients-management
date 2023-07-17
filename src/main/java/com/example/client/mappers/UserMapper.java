package com.example.client.mappers;

import com.example.client.data.UserDTO;
import com.example.client.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    static UserMapper getInstance() {
        return Mappers.getMapper(UserMapper.class);
    }

    @Mapping(target = "fullName", expression = "java(user.getFirstName() + \" \" + user.getLastName())")
    UserDTO userToDto(User user);

    User dtoToUser(UserDTO userDto);
}
