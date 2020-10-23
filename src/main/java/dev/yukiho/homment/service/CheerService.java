package dev.yukiho.homment.service;

import dev.yukiho.homment.db.model.Cheer;
import dev.yukiho.homment.repository.CheerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 応援コメントに関するサービスです
 */
@Service
public class CheerService {

    private final CheerRepository cheerRepository;

    @Autowired
    public CheerService(CheerRepository cheerRepository) {
        this.cheerRepository = cheerRepository;
    }

    /**
     * 応援コメントを保存します
     *
     * @param action
     * @param userId
     * @param roomId
     */
    public Cheer save(String action, int userId, int roomId) {
        final var cheer = new Cheer();
        cheer.setComment(action);
        cheer.setUserId(userId);
        cheer.setRoomId(roomId);

        cheerRepository.insert(cheer);

        return cheer;
    }
}
