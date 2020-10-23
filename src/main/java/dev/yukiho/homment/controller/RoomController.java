package dev.yukiho.homment.controller;

import dev.yukiho.homment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public String redirectToRoom(@RequestParam("password") String password) {
        // TODO 実装
        return "index";
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

        return "rooms/enter";
    }

    @GetMapping("/{roomId}/viewer")
    public String getViewer(Model model, @PathVariable("roomId") Integer roomId) {

        return "rooms/viewer";
    }
}
