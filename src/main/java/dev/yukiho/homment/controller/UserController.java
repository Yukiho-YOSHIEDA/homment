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

    UserService userService;

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

    @PostMapping
    public String registerUser(HttpServletResponse response,
                               @RequestParam("icon") MultipartFile icon,
                               @RequestParam("name") String name) {
        int userId;

        // iconが指定されていないときはデフォルトアイコンを設定する
        if (icon.isEmpty()) {
            try {
                final var inputStream = new ClassPathResource("static/images/default_icon.png").getInputStream();
                final var iconBytes = ByteStreams.toByteArray(inputStream);
                userId = userService.register(iconBytes, name);
            } catch (IOException e) {
                // TODO エラー処理
                e.printStackTrace();
                return "/index";
            }
        } else {
            try {
                final var iconBytes = icon.getBytes();
                userId = userService.register(iconBytes, name);
            } catch (IOException e) {
                // TODO エラー処理
                e.printStackTrace();
                return "/index";
            }
        }

        // cookieにユーザ情報を追加
        final var cookie = new Cookie("user", "" + userId);
        // cookieの残存期間(sec)
        cookie.setMaxAge(30 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:" + "/rooms/enter";
    }
}
