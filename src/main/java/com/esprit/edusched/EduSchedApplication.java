package com.esprit.edusched;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
import org.springframework.scheduling.annotation.EnableScheduling;

 
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
 
@SpringBootApplication
public class EduSchedApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduSchedApplication.class, args);
    }

}
