package dev.yukiho.homment.controller;

import dev.yukiho.homment.model.UserData;
import dev.yukiho.homment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserData getUser(@PathVariable("userId") Integer userId) {
        try {
            return userService.getUserData(userId);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new UserData();
        }
    }
}
