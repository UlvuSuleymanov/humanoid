package com.insta.humanoid.service;

import org.brunocvcunha.instagram4j.requests.payload.InstagramUserSummary;

import java.io.IOException;
import java.util.Set;

public interface DataService {
//    void startCollectTargetUser() throws IOException, InterruptedException;
    Set<InstagramUserSummary> getUserFollowers(String username) throws IOException, InterruptedException;

    void collectPostsFromTargetUsers() throws IOException, InterruptedException;

    void getPopularUserLastPost(String username);

    void getPostLiker() throws IOException;

    void getPostComments() throws IOException;

}
