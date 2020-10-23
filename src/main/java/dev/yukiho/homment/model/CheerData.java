package dev.yukiho.homment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheerData {

    private int commentedBy;
    private String action;
}
