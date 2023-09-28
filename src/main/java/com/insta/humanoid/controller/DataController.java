package com.insta.humanoid.controller;

import com.insta.humanoid.model.request.UserRequestModel;
import com.insta.humanoid.model.response.Statistic;
import com.insta.humanoid.repo.impl.DataRepositoryImpl;
import com.insta.humanoid.service.DataService;
import com.insta.humanoid.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("api/data")
public class DataController {

    private final ViewService viewService;

    private final DataService dataService;

    @Autowired
    public DataController(ViewService viewService, DataService dataService) {
        this.viewService = viewService;
        this.dataService = dataService;
    }


    @PostMapping("user/follower")
    public String fetshUserData(UserRequestModel user, Model model) throws IOException, InterruptedException {
        dataService.getUserFollowers(user.getUsername());
        return viewService.getDataPage(model);
    }

    @PostMapping("user/post")
    public String getUserPosts(UserRequestModel user, Model model) throws IOException, InterruptedException {
        dataService.getUserFollowers(user.getUsername());
        return viewService.getDataPage(model);
    }
}
