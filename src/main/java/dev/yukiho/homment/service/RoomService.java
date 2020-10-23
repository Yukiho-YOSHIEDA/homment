package dev.yukiho.homment.service;

import dev.yukiho.homment.db.model.Room;
import dev.yukiho.homment.db.model.RoomPassword;
import dev.yukiho.homment.model.RoomData;
import dev.yukiho.homment.repository.RoomPasswordRepository;
import dev.yukiho.homment.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * Roomに関するサービスです
 */
@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomPasswordRepository roomPasswordRepository;

    private final Random random;

    @Autowired
    public RoomService(RoomRepository roomRepository, RoomPasswordRepository roomPasswordRepository) {
        this.roomRepository = roomRepository;
        this.roomPasswordRepository = roomPasswordRepository;
        this.random = new Random();
    }

    /**
     * RoomIdからレコードを取得します
     *
     * @param roomId
     * @return
     */
    public Room getById(int roomId) {
        return roomRepository.selectById(roomId);
    }

    /**
     * パスワードからroomを検索します
     *
     * @param password
     * @return
     */
    public List<RoomPassword> getByPassword(int password) {
        return roomPasswordRepository.selectByPassword(password);
    }

    /**
     * Userによって作成されたRoomを取得します
     *
     * @param userId
     * @return
     */
    public List<RoomData> getRoomCreatedBy(int userId) {
        return roomRepository.selectByUserId(userId);
    }

    /**
     * 新しくRoomを作成します
     *
     * @param roomName
     * @param userId
     */
    @Transactional
    public void create(String roomName, int userId) {
        final var room = new Room();
        room.setName(roomName);
        room.setCreatedBy(userId);

        roomRepository.insert(room);

        while (true) {
            final var password = createPassword();
            // パスワードの重複がない
            if (roomPasswordRepository.selectByPassword(password).size() == 0) {
                final var roomPassword = new RoomPassword();
                roomPassword.setPassword(password);
                roomPassword.setRoomId(room.getId());

                roomPasswordRepository.insert(roomPassword);

                break;
            }
        }
    }

    /**
     * 部屋のパスワードを生成します
     *
     * @return
     */
    private int createPassword() {
        return random.nextInt(9000) + 1000;
    }
}
