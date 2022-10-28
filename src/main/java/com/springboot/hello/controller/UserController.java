package com.springboot.hello.controller;


import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.dto.User;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping(value = "/name")
    public String createUser(@RequestBody User user){
        userDao.add(user);
        String str = user.getId()+"가 등록되었습니다.";
        log.info(str);
        return str;
    }

    @GetMapping(value = "/user")
    public User getById(@RequestParam)




}
