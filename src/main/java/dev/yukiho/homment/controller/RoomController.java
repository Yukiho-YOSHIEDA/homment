package dev.yukiho.homment.controller;

import dev.yukiho.homment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

/**
 * Roomに関するController
 */
@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final UserService userService;

    @Autowired
    public RoomController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/enter")
    public String getEnterPage(@CookieValue(value = "user", required = false) String user, Model model) {
        // user登録がされていない
        if (Objects.isNull(user)) {
            return "redirect:" + "/users/register";
        }

        final var userId = Integer.parseInt(user);
        try {
            final var userData = userService.getUserData(userId);
            model.addAttribute("userData", userData);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "redirect:" + "/index";
        }

        return "/rooms/enter";
    }
}
