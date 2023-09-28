package com.insta.humanoid.service.impl;

import com.insta.humanoid.model.CustomModel;
import com.insta.humanoid.model.request.UserRequestModel;
import com.insta.humanoid.model.response.Statistic;
import com.insta.humanoid.repo.UserRepository;
import com.insta.humanoid.repo.impl.DataRepositoryImpl;
import com.insta.humanoid.service.ViewService;
import com.insta.humanoid.util.AuthGuard;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.io.IOException;

@Service
public class ViewServiceImpl implements ViewService {

    private final UserRepository userRepository;

    @Autowired
    public ViewServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String getHomePage(Model model) throws IOException, InterruptedException {

        if (AuthGuard.userIsLoggedIn) {
            InstagramUser instagramUser = userRepository.getUserByUsername(AuthGuard.instagram4j.getUsername());
            model.addAttribute("user", instagramUser);
            return "index";
        } else {
            model.addAttribute(new UserRequestModel("", ""));
            return "redirect:/login";
        }
    }

    @Override
    public String getDataPage(Model model) {
        model.addAttribute("user", new UserRequestModel("", ""));
        model.addAttribute("popularUsers", DataRepositoryImpl.popularUsers);

        if (AuthGuard.userIsLoggedIn) {
            model.addAttribute("statistic", new Statistic(
                    DataRepositoryImpl.popularUsers.size(),
                    DataRepositoryImpl.targetUsers.size(),
                    DataRepositoryImpl.ignoredUsers.size()
            ));
            return "data";
        } else
            return "redirect:/login";
    }

    @Override
    public String getLoginPage(Model model) throws IOException, InterruptedException {
        if (AuthGuard.userIsLoggedIn) {
            InstagramUser instagramUser = userRepository.getUserByUsername(AuthGuard.instagram4j.getUsername());
            model.addAttribute("user", instagramUser);
            return "redirect:/";
        } else {
            model.addAttribute("user", new UserRequestModel("", ""));
            return "login";
        }
    }
}
