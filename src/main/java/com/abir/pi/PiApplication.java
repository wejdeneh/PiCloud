package com.abir.pi;

import com.abir.pi.entities.Terrain;
import com.abir.pi.entities.User;
import com.abir.pi.repositories.TerrainRepository;
import com.abir.pi.services.TerrainService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PiApplication {

    public static void main(String[] args) {
       SpringApplication.run(PiApplication.class, args);

    }
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            // Add any initialization logic here
            System.out.println("Spring Boot application started!");
            // Keep the application running
            while (true) {
                Thread.sleep(10000000);
            }
        };
    }



}
