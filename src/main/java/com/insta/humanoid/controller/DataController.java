package com.insta.humanoid.controller;

import com.insta.humanoid.model.request.UserRequestModel;
import com.insta.humanoid.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("api/data")
public class DataController {

    private final ViewController viewController;

    private final DataService dataService;

    @Autowired
    public DataController(ViewController viewController, DataService dataService) {
        this.viewController = viewController;
        this.dataService = dataService;
    }


    @PostMapping("user/follower")
    public String fetshUserData(UserRequestModel user, Model model) throws IOException, InterruptedException {
        dataService.getUserFollowers(user.getUsername());
        return "redirect:/data";
    }
}
