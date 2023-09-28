package com.insta.humanoid;

import com.insta.humanoid.constants.FilePaths;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo {
    public static void main(String[] args) throws IOException {

        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        List<String> b = new ArrayList<>();
        b.add("0");
        b.addAll(a);
        System.out.println( b.get(0));

        String url = "src/main/resources/static/TargetUsers.txt";

        List<String> lines = Files.readAllLines(Path.of(url));

       String first = lines.remove(0);
       lines.add(first);

    }



}
