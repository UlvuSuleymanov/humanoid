package com.insta.humanoid.repo.impl;

import com.insta.humanoid.constants.FilePaths;
import com.insta.humanoid.repo.DataRepository;
import com.insta.humanoid.util.FileUtil;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.Set;

@Repository
public class DataRepositoryImpl implements DataRepository {
    public static Set<String> popularUsers;
    public static Set<String> targetUsers;
    public static Set<String> ignoredUsers;



    public DataRepositoryImpl() throws IOException {
        DataRepositoryImpl.popularUsers= FileUtil.readLines(FilePaths.POPULAR_USERS);
        DataRepositoryImpl.targetUsers=FileUtil.readLines(FilePaths.TARGET_USERS);
        DataRepositoryImpl.ignoredUsers=FileUtil.readLines(FilePaths.IGNORED_USERS);
    }



}
