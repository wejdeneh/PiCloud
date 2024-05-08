package com.esprit.edusched.services.impl;


public interface EmailService  {
    String sendMail(String to,String cc, String subject, String body);
}

