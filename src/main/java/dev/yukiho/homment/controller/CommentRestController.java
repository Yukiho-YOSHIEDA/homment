package dev.yukiho.homment.controller;

import dev.yukiho.homment.model.CheerData;
import dev.yukiho.homment.model.request.CheerRequest;
import dev.yukiho.homment.service.CheerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * commentするためのAPI
 */
@RestController
@RequestMapping("/api/rooms/{roomId}")
public class CommentRestController {

    private final CheerService cheerService;

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public CommentRestController(CheerService cheerService, SimpMessagingTemplate simpMessagingTemplate) {
        this.cheerService = cheerService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @PostMapping("/cheer")
    @ResponseStatus(HttpStatus.CREATED)
    public void postCheer(@CookieValue(value = "user", required = false) String userId,
                          @PathVariable("roomId") Integer roomId, @RequestBody CheerRequest request) {
        // 未認証の場合は今回はスルー
        if (Objects.isNull(userId)) {
            return;
        }

        final var cheer = cheerService.save(request.getAction(), Integer.parseInt(userId), roomId);
        final var response = new CheerData(cheer.getUserId(), cheer.getComment());

        simpMessagingTemplate.convertAndSend("/comment/rooms/" + roomId + "/updated", response);
    }
}
