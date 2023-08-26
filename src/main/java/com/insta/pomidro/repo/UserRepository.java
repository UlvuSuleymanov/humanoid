package com.insta.pomidro.repo;

import org.brunocvcunha.instagram4j.Instagram4j;

import java.io.IOException;

public interface UserRepository {
  public void add (Instagram4j instagram4j) throws IOException, ClassNotFoundException;
  public Instagram4j get (String username);

  }
