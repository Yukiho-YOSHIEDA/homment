package dev.yukiho.homment.controller;

import dev.yukiho.homment.model.RoomData;
import dev.yukiho.homment.service.RoomService;
import dev.yukiho.homment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Roomに関するController
 */
@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final UserService userService;
    private final RoomService roomService;

    @Autowired
    public RoomController(UserService userService, RoomService roomService) {
        this.userService = userService;
        this.roomService = roomService;
    }

    @GetMapping
    public String redirectToRoom(@RequestParam("password") String password) {
        // TODO 実装
        final var roomId = 1;
        return "redirect:" + "/rooms/" + roomId + "/cheer";
    }

    @PostMapping
    public String createRoom(@CookieValue(value = "user", required = false) String userId,
                             @RequestParam("name") String name) {
        // user登録がされていない
        if (Objects.isNull(userId)) {
            return "redirect:" + "/users/register";
        }

        roomService.create(name, Integer.parseInt(userId));

        return "redirect:" + "/rooms/list";
    }

    @GetMapping("/list")
    public String getRoomListPage(@CookieValue(value = "user", required = false) String user, Model model) {
        // user登録がされていない
        if (Objects.isNull(user)) {
            return "redirect:" + "/users/register/teacher";
        }

        final var roomList = roomService.getRoomCreatedBy(Integer.parseInt(user));
        model.addAttribute("rooms", roomList);

        return "rooms/list";
    }

    @GetMapping("/new")
    public String getNewRoomPage(@CookieValue(value = "user", required = false) String user) {
        // user登録がされていない
        if (Objects.isNull(user)) {
            return "redirect:" + "/users/register";
        }

        return "rooms/create";
    }

    @GetMapping("/enter")
    public String getEnterPage(@CookieValue(value = "user", required = false) String user) {
        // user登録がされていない
        if (Objects.isNull(user)) {
            return "redirect:" + "/users/register";
        }

        return "rooms/enter";
    }

    @GetMapping("/{roomId}/cheer")
    public String getCheerPage(@CookieValue(value = "user", required = false) String user,
                               @PathVariable("roomId") Integer roomId, Model model) {
        // user登録がされていない
        if (Objects.isNull(user)) {
            return "redirect:" + "/users/register";
        }

        final var userId = Integer.parseInt(user);
        try {
            final var userData = userService.getUserData(userId);
            model.addAttribute("userData", userData);
            model.addAttribute("roomId", roomId);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "redirect:" + "/index";
        }

        return "rooms/cheer";
    }

    @GetMapping("/{roomId}/viewer")
    public String getViewer(Model model, @PathVariable("roomId") Integer roomId) {

        return "rooms/viewer";
    }
}
