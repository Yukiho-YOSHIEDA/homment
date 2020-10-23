package dev.yukiho.homment.service;

import dev.yukiho.homment.db.model.User;
import dev.yukiho.homment.model.UserData;
import dev.yukiho.homment.repository.UserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

import static java.nio.charset.StandardCharsets.US_ASCII;

/**
 * Userに関するサービスです
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 表示に必要なUserDataを取得します
     *
     * @param userId
     * @return
     */
    public UserData getUserData(int userId) throws UnsupportedEncodingException {
        final var user = userRepository.selectById(userId);

        // データを表示できるように加工
        final var base64 = new String(Base64.encodeBase64(user.getIcon()), US_ASCII);
        String iconData = "data:image/jpeg;base64," + base64;

        final var userData = new UserData();
        userData.setName(user.getName());
        userData.setIcon(iconData);

        return userData;
    }

    /**
     * ユーザを新規登録します。
     *
     * @param icon
     * @param name
     * @return UserId
     */
    public int register(byte[] icon, String name) {
        final var user = new User();
        user.setIcon(icon);
        user.setName(name);

        final var result = userRepository.insert(user);

        return result.getId();
    }
}
