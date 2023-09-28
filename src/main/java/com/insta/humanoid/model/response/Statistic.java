package com.insta.humanoid.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistic {
    private int popularUserCount;
    private int targetUserCount;
    private int ignoredUserCount;
}
