package com.insta.humanoid.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private String username;
    private int likeCount ;
    private int commentCount;
    private int followCount ;
    private int unfollowCount ;
    private int unRequestCount;

}
