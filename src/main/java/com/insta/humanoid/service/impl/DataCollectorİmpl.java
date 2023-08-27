package com.insta.pomidro.service.impl;

import com.insta.pomidro.constants.FilePaths;
import com.insta.pomidro.repo.impl.DataRepositoryImpl;
import com.insta.pomidro.service.DataService;
import com.insta.pomidro.util.AuthGuard;
import com.insta.pomidro.util.FileUtil;
import com.insta.pomidro.util.RandomSleep;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.*;
import org.brunocvcunha.instagram4j.requests.payload.InstagramGetUserFollowersResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUserSummary;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Setter
@NoArgsConstructor
public class DataCollectorİmpl implements DataService {
    public  Instagram4j instagram = new Instagram4j("ad","das");

    Random random = new Random();

    public DataCollectorİmpl(Instagram4j instagram){
        this.instagram = instagram;
    }



    @Override
    public void startCollectTargetUser() throws IOException, InterruptedException {
        Set<String> popularUsers= readPopularUsers();
        Set<InstagramUserSummary> users = new HashSet<>();
        for(String username: popularUsers){
            Thread.sleep(random.nextInt(2,13));
            users.addAll(getUserFollowers(username));
            System.out.println(users.size());
        }

        writeUsers(users);

    }

    @Override
    public Set<InstagramUserSummary> getUserFollowers(String username) throws IOException, InterruptedException {
        InstagramSearchUsernameResult userResult = AuthGuard.instagram4j.sendRequest(new InstagramSearchUsernameRequest(username));
        Thread.sleep(random.nextInt(2,7));
        if(userResult.getUser().is_private)
        {
            System.out.println("user is private");
            return new HashSet<>();
        }
        InstagramGetUserFollowersResult result =  AuthGuard.instagram4j.sendRequest(new InstagramGetUserFollowersRequest(userResult.getUser().getPk(),null));

        Set<String> resultSet = result.users.stream().map(instagramUserSummary -> instagramUserSummary.getUsername()).collect(Collectors.toSet());
        DataRepositoryImpl.targetUsers.addAll(resultSet);
        FileUtil.appendLineList(FilePaths.TARGET_USERS,resultSet);
        FileUtil.appendLine(FilePaths.POPULAR_USERS,username);

        return new HashSet<>(result.users);
    }

    void writeUsers(Set<InstagramUserSummary> users) throws IOException {
        FileWriter myWriter = new FileWriter("src/main/resources/static/TargetUsers.txt");
        users.forEach( user->
        {
            try {
                myWriter.write(user.pk+System.getProperty("line.separator"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        myWriter.flush();

    }

    Set<String> readPopularUsers() throws IOException {
        Set<String> usernames = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/static/TargetPopularProfiles.txt"));
            String line = reader.readLine();

            while (line != null) {
                usernames.add(line);
                line = reader.readLine();
            }
         return usernames;
    }
}
