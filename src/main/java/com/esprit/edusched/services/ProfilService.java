package com.esprit.edusched.services;

import com.esprit.edusched.entities.User;
import com.esprit.edusched.enums.EnumClasse;
import com.esprit.edusched.enums.EnumSpecialite;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

public interface ProfilService {
    public User uploadImage(String name,String email, MultipartFile file, EnumClasse enumClasse, EnumSpecialite enumSpecialite, String number, String nationality) throws IOException;

}
