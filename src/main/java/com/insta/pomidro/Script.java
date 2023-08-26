package com.insta.pomidro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Script {
    public static void main(String[] args) throws IOException {
        FileWriter myWriter = new FileWriter("src/main/resources/static/TargetPopularProfiles");

        List<String> users = Arrays.asList("ulvu","ASDAAD","ASAS");
        Script script = new Script();
        script.saveUsernames(users);

     }



    void saveUsernames(List<String> usernames) throws IOException {
        FileWriter myWriter = new FileWriter("src/main/resources/static/TargetUsers");
        usernames.forEach( str->
        {
            try {
                myWriter.write(str+System.getProperty("line.separator"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        myWriter.close();
    }


}
