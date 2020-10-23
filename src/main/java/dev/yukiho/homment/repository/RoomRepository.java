package dev.yukiho.homment.repository;

import dev.yukiho.homment.db.mapper.RoomMapper;
import dev.yukiho.homment.db.mapper.RoomPasswordMapper;
import dev.yukiho.homment.db.mapper.advance.RoomAdvanceMapper;
import dev.yukiho.homment.db.model.Room;
import dev.yukiho.homment.model.RoomData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Roomテーブルにアクセスするためのリポジトリ
 */
@Repository
public class RoomRepository {

    private final RoomMapper roomMapper;
    private final RoomAdvanceMapper roomAdvanceMapper;

    @Autowired
    public RoomRepository(RoomMapper roomMapper,
                          RoomAdvanceMapper roomAdvanceMapper) {
        this.roomMapper = roomMapper;
        this.roomAdvanceMapper = roomAdvanceMapper;
    }

    /**
     * UserIdが作成したroomを取得します
     *
     * @param userId
     * @return
     */
    public List<RoomData> selectByUserId(int userId) {
        return roomAdvanceMapper.selectByUserId(userId);
    }

    /**
     * 新規roomを1件DBに保存します
     *
     * @param record
     */
    public void insert(Room record) {
        roomMapper.insertSelective(record);
    }
}
