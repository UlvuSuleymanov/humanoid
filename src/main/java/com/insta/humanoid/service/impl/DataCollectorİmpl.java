package com.insta.humanoid.service.impl;

import com.insta.humanoid.constants.FilePaths;
import com.insta.humanoid.custom.InstagramLikeCommentRequest;
import com.insta.humanoid.repo.UserRepository;
import com.insta.humanoid.repo.impl.DataRepositoryImpl;
import com.insta.humanoid.service.DataService;
import com.insta.humanoid.util.AuthGuard;
import com.insta.humanoid.util.FileUtil;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.*;
import org.brunocvcunha.instagram4j.requests.payload.InstagramGetUserFollowersResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUserSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Setter
@NoArgsConstructor
public class DataCollectorİmpl implements DataService {

    Random random = new Random();

    @Autowired
    private UserRepository userRepository;


    @Override
    public Set<InstagramUserSummary> getUserFollowers(String username) throws IOException, InterruptedException {
        InstagramUser user = userRepository.getUserByUsername(username);
        List<InstagramUserSummary> followerList = userRepository.getFollowersById(user.getPk());
        Set<String> followersString = followerList.stream().map(instagramUserSummary -> instagramUserSummary.getUsername()).collect(Collectors.toSet());
        FileUtil.appendLineList(FilePaths.TARGET_USERS, followersString);
        FileUtil.insertLine(FilePaths.POPULAR_USERS, username);
        return new HashSet<>(followerList);
    }

    @Override
    public void collectPostsFromTargetUsers() throws IOException, InterruptedException {

    }

    @Override
    public void getPopularUserLastPost(String username) {


    }

    @Override
    public void getPostLiker() throws IOException {
        //3199549471041276738
        var likers = AuthGuard.instagram4j.sendRequest(new InstagramGetMediaLikersRequest(3199549471041276738L));
        System.out.println("likers count:" + likers.getUsers().get(25).username);


    }

    @Override
    public void getPostComments() throws IOException {

        var commentsResult = AuthGuard.instagram4j.sendRequest(new InstagramGetMediaCommentsRequest("3199549471041276738", "asa"));
        System.out.println("comment id");
        System.out.println(commentsResult.getComments().get(0).getPk());


    }

    void likeComment() throws IOException {
        System.out.println("like comment");
        AuthGuard.instagram4j.sendRequest(new InstagramLikeCommentRequest(17908738319824329L));

    }






}
