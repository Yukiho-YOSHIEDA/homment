package dev.yukiho.homment.repository;

import dev.yukiho.homment.db.mapper.CheerMapper;
import dev.yukiho.homment.db.model.Cheer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * cheerテーブルにアクセスするためのリポジトリ
 */
@Repository
public class CheerRepository {
    private final CheerMapper cheerMapper;

    @Autowired
    public CheerRepository(CheerMapper cheerMapper) {
        this.cheerMapper = cheerMapper;
    }

    /**
     * recordを1件DBに挿入します
     *
     * @param record
     */
    public void insert(Cheer record) {
        cheerMapper.insertSelective(record);
    }
}
