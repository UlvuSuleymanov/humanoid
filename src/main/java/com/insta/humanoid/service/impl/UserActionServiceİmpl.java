package com.insta.humanoid.service.impl;

import com.insta.humanoid.service.UserAction;
import com.insta.humanoid.util.AuthGuard;
import org.brunocvcunha.instagram4j.requests.InstagramFollowRequest;
import org.brunocvcunha.instagram4j.requests.InstagramLikeRequest;
import org.brunocvcunha.instagram4j.requests.InstagramUserFeedRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class UserActionServiceİmpl implements UserAction {
    @Override
    public List<InstagramFeedItem> getUserPosts(Long id) throws IOException {
        InstagramFeedResult instagramUserReelMediaFeedResult =
                AuthGuard.instagram4j.sendRequest(new InstagramUserFeedRequest(id));
       return instagramUserReelMediaFeedResult.getItems();

    }

    @Override
    public void follow(Long id) throws IOException {
        AuthGuard.instagram4j.sendRequest(new InstagramFollowRequest(id));
    }

    @Override
    public void likePost(Long id) throws IOException {
        AuthGuard.instagram4j.sendRequest(new InstagramLikeRequest(id));
    }
}
