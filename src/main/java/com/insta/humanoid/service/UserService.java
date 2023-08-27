package com.insta.humanoid.service;

import com.insta.humanoid.model.request.UserRequestModel;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface UserService {
    void login(UserRequestModel userRequestModel) throws IOException, ExecutionException, InterruptedException, ClassNotFoundException;
}
