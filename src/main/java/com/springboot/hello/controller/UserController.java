package com.springboot.hello.controller;


import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.dto.User;
import com.springboot.hello.domain.dto.UserRequestDto;
import io.swagger.models.auth.In;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<Integer> createUser(@RequestBody UserRequestDto userRequestDto){
        User user = new User(userRequestDto.getId(), userRequestDto.getName(), userRequestDto.getPassword());
        return ResponseEntity
                .ok()
                .body(userDao.add(user));
    }
    @GetMapping(value = "/user/{id}")
    public User getById(@PathVariable String id){
        User user = userDao.findById(id);
        return user;
    }

    @DeleteMapping(value = "/user/delete/all")
    public ResponseEntity<Integer> deleteAll() throws SQLException {
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }
    @GetMapping(value = "user/delete/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable String id){
        return ResponseEntity
                .ok()
                .body(userDao.deleteById(id));
    }

}
