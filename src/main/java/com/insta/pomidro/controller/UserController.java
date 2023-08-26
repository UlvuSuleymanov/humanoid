package com.insta.pomidro.controller;

import com.insta.pomidro.model.request.UserRequestModel;
import com.insta.pomidro.repo.UserRepository;
import com.insta.pomidro.service.UserService;
import com.insta.pomidro.util.AuthGuard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Slf4j
@Controller
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserRequestModel("", ""));

        System.out.println("user logged in");
        if (AuthGuard.userIsLoggedIn) {
            return "index";
        } else {
            return "login";
        }

    }

    @GetMapping("signin")
    public String signin(Model model) {
        model.addAttribute("user", new UserRequestModel("", ""));

        System.out.println("user logged in");
       return "signin";

    }

    @PostMapping("/login")
    public String login(UserRequestModel user) throws IOException, ExecutionException, InterruptedException, ClassNotFoundException {

        log.info("add called");
        userService.login(user);
        System.out.println(AuthGuard.userIsLoggedIn);
        System.out.println(AuthGuard.instagram4j);


        return "index";
    }


}
