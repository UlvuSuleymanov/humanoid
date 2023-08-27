package com.insta.humanoid.util;

import com.insta.humanoid.constants.FilePaths;
import com.insta.humanoid.repo.impl.DataRepositoryImpl;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class FileUtil {
    public static Set<String> readLines(FilePaths url) throws IOException {
        return new HashSet<>(Files.readAllLines(Paths.get(url.getUrl())));
    }

    public static void appendLine(FilePaths filePaths,String username) throws IOException {
        FileWriter myWriter = new FileWriter(filePaths.getUrl(), true);
        myWriter.append(username + System.getProperty("line.separator"));
        myWriter.flush();
        myWriter.close();
    }


    public static void appendLineList(FilePaths filePaths, Set<String> lines ) throws IOException {
        FileWriter myWriter = new FileWriter(filePaths.getUrl(), true);
        lines.forEach(line ->
        {
            try {
                myWriter.append(line + System.getProperty("line.separator"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        myWriter.flush();
        myWriter.close();
    }

    public static void replaceLineList( FilePaths filePaths, Set<String> lines) throws IOException {
        FileWriter myWriter = new FileWriter(filePaths.getUrl());
        lines.forEach(line ->
        {
            try {
                myWriter.append(line + System.getProperty("line.separator"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        myWriter.flush();
        myWriter.close();
    }


   public static void synchronize() throws IOException {
        replaceLineList(FilePaths.TARGET_USERS, DataRepositoryImpl.targetUsers);

    }
}
