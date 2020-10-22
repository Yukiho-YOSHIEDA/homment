package dev.yukiho.homment.repository;

import dev.yukiho.homment.db.mapper.UserMapper;
import dev.yukiho.homment.db.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Userテーブルにアクセスするためのリポジトリ
 */
@Repository
public class UserRepository {

    private final UserMapper userMapper;

    @Autowired
    public UserRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * レコードを1件検索します
     * 見つからない場合はnullが返却されます
     *
     * @param id UserId
     * @return
     */
    public User selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * レコードを1件挿入します
     *
     * @param user
     * @return
     */
    public User insert(User user) {
        userMapper.insertSelective(user);
        return user;
    }
}
