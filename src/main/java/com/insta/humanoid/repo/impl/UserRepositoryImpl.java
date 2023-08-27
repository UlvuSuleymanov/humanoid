package com.insta.humanoid.repo.impl;

import com.insta.humanoid.repo.UserRepository;
import com.insta.humanoid.util.AuthGuard;
import lombok.extern.slf4j.Slf4j;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {


    private Map<String,Instagram4j> users = new HashMap<>();
    public void add (final Instagram4j instagram4j) throws IOException, ClassNotFoundException {
        users.put(instagram4j.getUsername(),instagram4j);
     }

    @Override
    public InstagramUser getUserByUsername(String username) throws IOException {
     return  AuthGuard.instagram4j.sendRequest(new InstagramSearchUsernameRequest(username)).getUser();
    }

    @Override
    public Instagram4j get(String username) {
     return  users.get(username);
     }
}
