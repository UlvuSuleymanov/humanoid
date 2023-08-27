package com.insta.humanoid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;

@SpringBootApplication
@EnableAsync
public class PomidroApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(PomidroApplication.class, args);

    }

}
