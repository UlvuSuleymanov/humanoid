package com.insta.humanoid.repo;

import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUserSummary;

import java.io.IOException;
import java.util.List;

public interface UserRepository {

  public InstagramUser getUserByUsername(String username) throws IOException, InterruptedException;
  public List<InstagramUserSummary> getFollowersById(Long id) throws IOException, InterruptedException;
  }
