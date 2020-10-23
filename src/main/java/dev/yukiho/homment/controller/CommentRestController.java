package dev.yukiho.homment.controller;

import dev.yukiho.homment.model.request.CheerRequest;
import dev.yukiho.homment.service.CheerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * commentするためのAPI
 */
@RestController
@RequestMapping("/api/rooms/{roomId}")
public class CommentRestController {

    private final CheerService cheerService;

    @Autowired
    public CommentRestController(CheerService cheerService) {
        this.cheerService = cheerService;
    }

    @PostMapping("/cheer")
    @ResponseStatus(HttpStatus.CREATED)
    public void postCheer(@CookieValue(value = "user", required = false) String userId,
                          @PathVariable("roomId") Integer roomId, @RequestBody CheerRequest request) {
        // 未認証の場合は今回はスルー
        if (Objects.isNull(userId)) {
            return;
        }

        cheerService.save(request.getAction(), Integer.parseInt(userId), roomId);
    }
}
