package dev.yukiho.homment.repository;

import dev.yukiho.homment.db.mapper.RoomPasswordMapper;
import dev.yukiho.homment.db.model.RoomPassword;
import dev.yukiho.homment.db.model.RoomPasswordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * room_passwordテーブルにアクセスするためのリポジトリ
 */
@Repository
public class RoomPasswordRepository {
    private final RoomPasswordMapper roomPasswordMapper;

    @Autowired
    public RoomPasswordRepository(RoomPasswordMapper roomPasswordMapper) {
        this.roomPasswordMapper = roomPasswordMapper;
    }

    /**
     * Passwordからレコードを取得します
     *
     * @param password
     * @return
     */
    public List<RoomPassword> selectByPassword(int password) {
        final var example = new RoomPasswordExample();
        example.createCriteria().andPasswordEqualTo(password).andIsDeletedEqualTo(Boolean.FALSE);
        return roomPasswordMapper.selectByExample(example);
    }

    /**
     * DBに1件挿入します
     *
     * @param record
     */
    public void insert(RoomPassword record) {
        record.setIsDeleted(Boolean.FALSE);
        roomPasswordMapper.insertSelective(record);
    }
}
