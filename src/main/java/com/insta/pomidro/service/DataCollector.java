package com.insta.pomidro.service;

import org.brunocvcunha.instagram4j.requests.payload.InstagramUserSummary;

import java.io.IOException;
import java.util.Set;

public interface DataCollector {
    void startCollectTargetUser() throws IOException, InterruptedException;
    Set<InstagramUserSummary> getUserFollowers(String username) throws IOException, InterruptedException;
}
