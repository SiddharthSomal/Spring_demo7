package com.pixel0.Ex11.service;

import com.pixel0.Ex11.dao.UserRepository;
import com.pixel0.Ex11.dto.UserDto;
import com.pixel0.Ex11.dtomapper.UserMapper;
import com.pixel0.Ex11.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository repo;
    public UserService(UserRepository repo){
        this.repo = repo;
    }
    public UserDto addUser(UserDto dto){
        User user = UserMapper.toEntity(dto);
        User saved = repo.save(user);
        return UserMapper.toDto(saved);
    }
    public List<UserDto> getAllUsers(){
        return repo.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }
    public UserDto getUserById(Long id){
        return repo.findById(id)
                .map(UserMapper::toDto)
                .orElse(null);
    }
}
