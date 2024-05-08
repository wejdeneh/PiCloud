package com.esprit.edusched.services;

import com.esprit.edusched.dto.SignupRequest;
import com.esprit.edusched.entities.User;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface AuthService {
    User createUser(SignupRequest signupRequest) throws MessagingException, UnsupportedEncodingException;
    void sendVerificationEmail(User user) throws MessagingException, UnsupportedEncodingException;

    public boolean verifyUser(String token);

}
