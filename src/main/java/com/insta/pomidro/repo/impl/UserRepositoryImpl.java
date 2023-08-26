package com.insta.pomidro.repo.impl;

import com.insta.pomidro.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {


    private Map<String,Instagram4j> users = new HashMap<>();
    public void add (final Instagram4j instagram4j) throws IOException, ClassNotFoundException {
        users.put(instagram4j.getUsername(),instagram4j);
     }

    @Override
    public Instagram4j get(String username) {
     return     users.get(username);
     }
}
