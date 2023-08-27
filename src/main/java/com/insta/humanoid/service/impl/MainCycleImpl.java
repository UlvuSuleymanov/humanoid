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
public class MainCycleImpl implements MainCycle {
    private final UserRepository userRepository;
    private final UserAction userActionService;

    User user = new User();

    @Autowired
    public MainCycleImpl(UserRepository userRepository, UserAction userActionService) {
        this.userRepository = userRepository;
        this.userActionService = userActionService;
    }

    @Async
    @Override
    public void start(int limit) throws IOException, InterruptedException {
        Random random = new Random();
        Instagram4j instagram4j = AuthGuard.instagram4j;
        Set<String> usernames = DataRepositoryImpl.targetUsers;
        int i = 0;

        try {

            for (final String username : usernames) {
                DataRepositoryImpl.targetUsers.remove(username);
                System.out.println("sleep");
                TimeUnit.SECONDS.sleep(6 + (random.nextInt() % 10));
                System.out.println("wake");
                i++;
                if (i > limit)
                    break;


                if (DataRepositoryImpl.ignoredUsers.contains(username))
                    continue;

                log.info("current user in loop :", username);
                InstagramUser instagramUser;

                try {
                    instagramUser = userRepository.getUserByUsername(username);
                } catch (Exception e) {
                    continue;
                }
                FileUtil.appendLine(FilePaths.IGNORED_USERS, username);
                DataRepositoryImpl.ignoredUsers.add(username);


                //main actions
                if (instagramUser.is_private &&
                        instagramUser.follower_count < instagramUser.following_count
                        && instagramUser.follower_count < 200) {
                    log.info("user start following", username);
                    userActionService.follow(instagramUser.pk);
                    user.setFollowCount(user.getFollowCount() + 1);
                    continue;
                }


                if (!instagramUser.is_private && instagramUser.media_count > 0) {
                    List<InstagramFeedItem> posts = userActionService.getUserPosts(instagramUser.pk);
                    int k = 0;
                    for (InstagramFeedItem instagramFeedItem : posts) {
                        k = k + 1;
                        if (k > 3)
                            break;
                        userActionService.likePost(instagramFeedItem.pk);
                        user.setLikeCount(user.getLikeCount() + 1);
                        TimeUnit.SECONDS.sleep(15 + (random.nextInt() % 10));
                        log.info("liked user {} post", username);
                    }
                    continue;
                }


                System.out.println(user.toString());


            }

        } catch (Exception e) {

        } finally {
            FileUtil.synchronize();
        }

    }
}
