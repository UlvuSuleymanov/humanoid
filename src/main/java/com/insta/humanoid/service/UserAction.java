package com.insta.humanoid.service;

import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;

import java.io.IOException;
import java.util.List;

public interface UserAction {
    List<InstagramFeedItem> getUserPosts(Long id) throws IOException;

    void follow(Long id) throws IOException;

    void likePost(Long id) throws IOException;
}
