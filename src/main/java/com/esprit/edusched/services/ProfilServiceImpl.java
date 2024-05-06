package com.esprit.edusched.services;

import com.esprit.edusched.entities.User;
import com.esprit.edusched.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProfilServiceImpl implements ProfilService {
    @Autowired
    private final UserRepository userRepository;

    public ProfilServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User uploadImage(String email, MultipartFile file) throws IOException {
        // Retrieve the currently authenticated user
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userEmail = authentication.getName();

        // Retrieve the user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Set the image bytes to the user entity
        user.setImage(file.getBytes());
        // Save the updated user entity
        User u = userRepository.save(user);
//        u.setImage(null);
        return u;
    }

}