package com.esprit.edusched.services;

import com.esprit.edusched.entities.User;
import com.esprit.edusched.repositories.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService{
    @Resource
    public UserRepository userRepository;
    @Resource
    public PasswordEncoder passwordEncoder;
    @Override
    public String setPassword(String email, String oldPassword, String newPassword) {
        // Retrieve the user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));

        // Check if the old password matches the current password
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            return "Old password does not match.";
        }

        // Check if the old password is the same as the new password
        if (passwordEncoder.matches(newPassword, user.getPassword())) {
            return "New password must be different from the old one.";
        }

        // Encode the new password
        String hashedPassword = passwordEncoder.encode(newPassword);

        // Update the user's password
        user.setPassword(hashedPassword);
        userRepository.save(user);

        return "Password changed successfully.";
    }

}
