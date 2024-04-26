package com.esprit.edusched.services;

import com.esprit.edusched.entities.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProfilService {
    public User uploadImage(String name,MultipartFile file) throws IOException;

}
