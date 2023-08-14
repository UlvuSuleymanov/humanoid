package com.insta.pomidro.controller;


import com.insta.pomidro.model.request.UserRequestModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @PostMapping("/login")
    public String login(UserRequestModel user){
        System.out.println(user.getPassword());
        return "index";
    }

    @GetMapping
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserRequestModel("",""));
        return "login";
    }
}
