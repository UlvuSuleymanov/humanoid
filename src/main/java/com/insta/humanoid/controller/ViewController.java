package com.insta.pomidro.controller;

import com.insta.pomidro.model.request.UserRequestModel;
import com.insta.pomidro.repo.UserRepository;
import com.insta.pomidro.util.AuthGuard;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class ViewController {



    private final UserRepository userRepository;

    @Autowired
    public ViewController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    String getIndex(Model model) throws IOException {
        if(AuthGuard.userIsLoggedIn) {
            InstagramUser instagramUser = userRepository.getUserByUsername(AuthGuard.instagram4j.getUsername());
            model.addAttribute("user", instagramUser);
        }
        else{
            model.addAttribute(new UserRequestModel("",""));
        }
        return AuthGuard.userIsLoggedIn? "index" : "redirect:/login";
    }

    @GetMapping("/data")
    String getDataPage(Model model) {
        model.addAttribute("user", new UserRequestModel("", ""));
        return AuthGuard.userIsLoggedIn? "data" : "redirect:/login";

     }

    @GetMapping("/login")
    public String openLogin(Model model) throws IOException {
        model.addAttribute("user", new UserRequestModel("", ""));
        return AuthGuard.userIsLoggedIn? getIndex(model) : "login";

    }

}
