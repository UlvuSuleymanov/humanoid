package com.insta.pomidro.controller;

import com.insta.pomidro.model.request.UserRequestModel;
import com.insta.pomidro.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
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
    String fetshUserData(UserRequestModel user) throws IOException, InterruptedException {
        dataService.getUserFollowers(user.getUsername());
        return "data";
    }
}
