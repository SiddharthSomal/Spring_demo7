package com.pixel0.Ex11.dtomapper;

import com.pixel0.Ex11.dto.UserDto;
import com.pixel0.Ex11.model.User;

public class UserMapper {
    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
    public static User toEntity(UserDto dto){
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }

}
