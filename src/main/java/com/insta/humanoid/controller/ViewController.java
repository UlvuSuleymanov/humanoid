package com.insta.humanoid.controller;

import com.insta.humanoid.model.request.UserRequestModel;
import com.insta.humanoid.repo.UserRepository;
import com.insta.humanoid.repo.impl.DataRepositoryImpl;
import com.insta.humanoid.util.AuthGuard;
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

        if (AuthGuard.userIsLoggedIn) {
            InstagramUser instagramUser = userRepository.getUserByUsername(AuthGuard.instagram4j.getUsername());
            model.addAttribute("user", instagramUser);
            return "index";
        } else {
            model.addAttribute(new UserRequestModel("", ""));
            return "redirect:/login";
        }
    }


    @GetMapping("/login")
    public String openLogin(Model model) throws IOException {
        if (AuthGuard.userIsLoggedIn) {
            InstagramUser instagramUser = userRepository.getUserByUsername(AuthGuard.instagram4j.getUsername());
            model.addAttribute("user", instagramUser);
            return "redirect:/";
        } else {
            model.addAttribute("user", new UserRequestModel("", ""));
            return "login";
        }
    }

    @GetMapping("/data")
    String getDataPage(Model model) {
        model.addAttribute("user", new UserRequestModel("", ""));
        model.addAttribute("popularUsers", DataRepositoryImpl.popularUsers);

        if (AuthGuard.userIsLoggedIn)
            return "data";
        else
            return "redirect:/login";

    }

}
