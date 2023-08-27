package com.insta.pomidro.service;

import com.insta.pomidro.model.request.UserRequestModel;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface UserService {
    void login(UserRequestModel userRequestModel) throws IOException, ExecutionException, InterruptedException, ClassNotFoundException;
}
