package com.insta.humanoid.controller;
import com.insta.humanoid.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class ViewController {

    private final ViewService viewService;

    @Autowired
    public ViewController(ViewService viewService) {
        this.viewService = viewService;
    }

    @GetMapping
    String getIndex(Model model) throws IOException, InterruptedException {
        return viewService.getHomePage(model);
    }

    @GetMapping("/login")
    public String openLogin(Model model) throws IOException, InterruptedException {
        return viewService.getLoginPage(model);
    }

    @GetMapping("/data")
    String getDataPage(Model model) {
        return viewService.getDataPage(model);

    }

}
