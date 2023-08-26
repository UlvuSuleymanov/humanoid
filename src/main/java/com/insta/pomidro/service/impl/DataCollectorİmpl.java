package com.insta.pomidro.service.impl;

import com.insta.pomidro.service.DataCollector;
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

@Service
@Setter
@NoArgsConstructor
public class DataCollectorİmpl implements DataCollector {
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
        Set<InstagramUserSummary> users = new HashSet<>();

        InstagramSearchUsernameResult userResult = instagram.sendRequest(new InstagramSearchUsernameRequest(username));
        Thread.sleep(random.nextInt(2,7));

        InstagramGetUserFollowersResult result =  instagram.sendRequest(new InstagramGetUserFollowersRequest(userResult.getUser().getPk(),null));

        System.out.println("next max id"+result.next_max_id);
        users.addAll(result.users);

        for(int i =0;i<15;i++){
            Thread.sleep(random.nextInt(2,7));
            result = instagram.sendRequest(new InstagramGetUserFollowersRequest(userResult.getUser().getPk(),result.next_max_id));
            users.addAll(users);
            System.out.println("userfollower"+users.size());

            RandomSleep.start(2,5);
        }


        return users;
    }

    void writeUsers(Set<InstagramUserSummary> users) throws IOException {
        FileWriter myWriter = new FileWriter("src/main/resources/static/TargetUsers");
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
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/static/TargetPopularProfiles"));
            String line = reader.readLine();

            while (line != null) {
                usernames.add(line);
                line = reader.readLine();
            }
         return usernames;
    }
}
