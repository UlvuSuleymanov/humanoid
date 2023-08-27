package com.insta.pomidro;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class PomidroApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(PomidroApplication.class, args);

    }

}
