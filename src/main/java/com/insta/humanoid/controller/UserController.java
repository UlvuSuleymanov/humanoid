package com.insta.pomidro.controller;

import com.insta.pomidro.model.request.UserRequestModel;
import com.insta.pomidro.repo.UserRepository;
import com.insta.pomidro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
public class UserController {
    private final ViewController viewController;

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(ViewController viewController, UserService userService, UserRepository userRepository) {
        this.viewController = viewController;
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @PostMapping("/login")
    public void login(UserRequestModel user, Model model) throws IOException, ExecutionException, InterruptedException, ClassNotFoundException {
        userService.login(user);
        viewController.openLogin(model);

    }





}
