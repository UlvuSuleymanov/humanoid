package com.insta.humanoid.service.impl;

import com.insta.humanoid.model.request.UserRequestModel;
import com.insta.humanoid.repo.UserRepository;
import com.insta.humanoid.service.UserService;
import com.insta.humanoid.util.AuthGuard;
import lombok.extern.slf4j.Slf4j;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Random;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    Random random = new Random();

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void login(UserRequestModel userRequestModel) throws IOException {
        Instagram4j instagram = new Instagram4j(userRequestModel.getUsername(), userRequestModel.getPassword());
        instagram.setup();
       if(instagram.login().getStatus().equals("fail"))
           throw new RuntimeException("EEE");

        AuthGuard.userIsLoggedIn=true;
        AuthGuard.instagram4j = instagram;
    }

}
