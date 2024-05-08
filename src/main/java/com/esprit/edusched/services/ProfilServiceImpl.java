package com.esprit.edusched.services;

import com.esprit.edusched.entities.User;
import com.esprit.edusched.enums.EnumClasse;
import com.esprit.edusched.enums.EnumSpecialite;
import com.esprit.edusched.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class ProfilServiceImpl implements ProfilService {
    @Autowired
    private final UserRepository userRepository;

    public ProfilServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User uploadImage(String name,String email, MultipartFile file, EnumClasse enumClasse, EnumSpecialite enumSpecialite, String number, String nationality) throws IOException {
        // Retrieve the user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Set the image bytes to the user entity
        user.setName(name);
        user.setImage(file.getBytes());
        user.setEnumClasse(enumClasse);
        user.setEnumSpecialite(enumSpecialite);
        user.setNumber(number);
        user.setNationality(nationality);
        user.setCreationDate(java.util.Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        // Save the updated user entity
        User u = userRepository.save(user);
//        u.setImage(null);
        return u;
    }

}