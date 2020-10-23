package dev.yukiho.homment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * room一覧表示モデル
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomData {
    private int id;
    private String name;
    private String password;
}
