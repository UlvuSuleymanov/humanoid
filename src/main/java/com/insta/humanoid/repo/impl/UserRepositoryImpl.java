package com.insta.humanoid.repo.impl;

import com.insta.humanoid.repo.UserRepository;
import com.insta.humanoid.util.AuthGuard;
import lombok.extern.slf4j.Slf4j;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramGetUserFollowersRequest;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramGetUserFollowersResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUserSummary;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;

@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {

    Random random = new Random();
    @Override
    public InstagramUser getUserByUsername(String username) throws IOException, InterruptedException {
        log.info("Waiting for fetch user {}",username);
        Thread.sleep(random.nextInt(2000,6500));
        var userResult = Optional.ofNullable(
                AuthGuard.instagram4j.sendRequest(
                        new InstagramSearchUsernameRequest(username)
                )
        );
        log.info("User {} is ready for use",username);

        return userResult.get().getUser();
    }

    @Override
    public List<InstagramUserSummary> getFollowersById(Long id) throws IOException, InterruptedException {
        log.info("Waiting for fetch user followers");
        Thread.sleep(random.nextInt(3900,9500));
        var result = AuthGuard.instagram4j.sendRequest(new InstagramGetUserFollowersRequest(id, null));
        log.info("User followers list are ready. Size: {} ", result.users.size());

        return result.users;
    }

}
