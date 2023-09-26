package com.insta.humanoid.controller;

import com.insta.humanoid.model.request.UserRequestModel;
import com.insta.humanoid.repo.UserRepository;
import com.insta.humanoid.service.MainCycle;
import com.insta.humanoid.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Slf4j
@Controller
public class UserController {
    private final ViewController viewController;

    private final UserService userService;
    private final UserRepository userRepository;

    private final MainCycle mainCycle;

    @Autowired
    public UserController(ViewController viewController, UserService userService, UserRepository userRepository, MainCycle mainCycle) {
        this.viewController = viewController;
        this.userService = userService;
        this.userRepository = userRepository;
        this.mainCycle = mainCycle;
    }


    @PostMapping("/login")
    public String login(UserRequestModel user, Model model) throws IOException, ExecutionException, InterruptedException, ClassNotFoundException {
        userService.login(user);
         return "redirect:/";
    }





}
