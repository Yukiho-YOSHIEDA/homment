package dev.yukiho.homment.controller;

import com.google.common.io.ByteStreams;
import dev.yukiho.homment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * Userに関するController
 */
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(@CookieValue(value = "user", required = false) String user) {
        // userが登録されていた場合は入室画面に遷移
        if (Objects.nonNull(user)) {
            return "redirect:" + "/rooms/enter";
        }

        return "users/register";
    }

    @GetMapping("/register/teacher")
    public String getRegisterTeacherPage(@CookieValue(value = "user", required = false) String user) {
        // userが登録されていた場合は入室画面に遷移
        if (Objects.nonNull(user)) {
            return "redirect:" + "/rooms/list";
        }

        return "users/register_teacher";
    }

    @PostMapping
    public String registerUser(HttpServletResponse response,
                               @RequestParam("icon") MultipartFile icon,
                               @RequestParam("name") String name) {
        int userId;
        try {
            userId = register(icon, name);
        } catch (IOException e) {
            // TODO エラー処理
            e.printStackTrace();
            return "index";
        }

        // cookieにユーザ情報を追加
        final var cookie = new Cookie("user", "" + userId);
        // cookieの残存期間(sec)
        cookie.setMaxAge(30 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:" + "/rooms/enter";
    }

    @PostMapping("/teacher")
    public String registerUserOfTeacher(HttpServletResponse response,
                                        @RequestParam("icon") MultipartFile icon,
                                        @RequestParam("name") String name) {

        int userId;
        try {
            userId = register(icon, name);
        } catch (IOException e) {
            // TODO エラー処理
            e.printStackTrace();
            return "index";
        }

        // cookieにユーザ情報を追加
        final var cookie = new Cookie("user", "" + userId);
        // cookieの残存期間(sec)
        cookie.setMaxAge(30 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:" + "/rooms/list";
    }

    private int register(MultipartFile icon, String name) throws IOException {
        int userId;

        // iconが指定されていないときはデフォルトアイコンを設定する
        if (icon.isEmpty()) {
            final var inputStream = new ClassPathResource("static/images/default_icon.png").getInputStream();
            final var iconBytes = ByteStreams.toByteArray(inputStream);
            userId = userService.register(iconBytes, name);
        } else {
            final var iconBytes = icon.getBytes();
            userId = userService.register(iconBytes, name);
        }

        return userId;
    }
}
