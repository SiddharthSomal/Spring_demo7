package com.pixel0.Ex11.controller;

import com.pixel0.Ex11.dto.UserDto;
import com.pixel0.Ex11.dtomapper.UserMapper;
import com.pixel0.Ex11.model.User;
import com.pixel0.Ex11.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    UserService service;
    public UserController(UserService service){
        this.service = service;
    }
    @GetMapping("/")
    public String greet(){
        return "Hello";
    }
    @GetMapping
    public List<UserDto> getUsers(){
        return service.getAllUsers();
    }
    @GetMapping("findUser/{id}")
    public UserDto findUser(@PathVariable Long id){
        return service.getUserById(id);
    }
}
