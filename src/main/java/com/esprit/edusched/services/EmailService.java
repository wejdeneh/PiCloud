package com.esprit.edusched.services;

import com.esprit.edusched.entities.AbstractEmailContext;
import jakarta.mail.MessagingException;

public interface EmailService {
    void sendMail(AbstractEmailContext email)throws MessagingException;
    public void sendPasswordEmail(String email) throws MessagingException;
}
