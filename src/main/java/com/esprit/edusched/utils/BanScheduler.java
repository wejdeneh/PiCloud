package com.esprit.edusched.utils;

import com.esprit.edusched.entities.User;
import com.esprit.edusched.repositories.UserRepository;
import com.esprit.edusched.services.jwt.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BanScheduler {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userService;

    // Method to check for expired bans and unban users
    @Scheduled(cron = "0 0 0 * * *") // Run daily at midnight
    public void checkAndUnbanUsers() {
        List<User> bannedUsers = userRepository.findByBannedTrue();
        for (User user : bannedUsers) {
            if (user.isBanExpired()) {
                userService.unbanUser(user.getEmail());
                userRepository.save(user);
            }
        }
    }
}
