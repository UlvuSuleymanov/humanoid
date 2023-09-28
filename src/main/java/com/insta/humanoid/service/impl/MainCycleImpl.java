package com.insta.humanoid.service.impl;

import com.insta.humanoid.constants.FilePaths;
import com.insta.humanoid.model.User;
import com.insta.humanoid.repo.UserRepository;
import com.insta.humanoid.repo.impl.DataRepositoryImpl;
import com.insta.humanoid.service.MainCycle;
import com.insta.humanoid.service.UserAction;
import com.insta.humanoid.util.AuthGuard;
import com.insta.humanoid.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class MainCycleImpl {
}
