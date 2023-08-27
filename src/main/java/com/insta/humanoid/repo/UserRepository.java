package com.insta.humanoid.repo;

import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;

import java.io.IOException;

public interface UserRepository {
  public void add (Instagram4j instagram4j) throws IOException, ClassNotFoundException;

  public InstagramUser getUserByUsername(String username) throws IOException;
  public Instagram4j get (String username);

  }
