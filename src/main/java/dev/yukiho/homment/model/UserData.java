package dev.yukiho.homment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserData表示用モデル
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    private String icon;
    private String name;
}
