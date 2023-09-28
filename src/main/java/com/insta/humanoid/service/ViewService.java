package com.insta.humanoid.service;

import com.insta.humanoid.model.CustomModel;
import org.springframework.ui.Model;

import java.io.IOException;

public interface ViewService {
    String getHomePage(Model model) throws IOException, InterruptedException;
    String getDataPage(Model model);
    String getLoginPage(Model model) throws IOException, InterruptedException;

}
