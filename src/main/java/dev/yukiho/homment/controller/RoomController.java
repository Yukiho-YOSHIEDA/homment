package dev.yukiho.homment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

/**
 * Roomに関するController
 */
@Controller
@RequestMapping("/rooms")
public class RoomController {

    @GetMapping("/enter")
    public String getEnterPage(@CookieValue(value = "user", required = false) String user) {
        // user登録がされている
        if (Objects.isNull(user)) {
            return "redirect:" + "/users/register";
        }
        return "/rooms/enter";
    }
}
