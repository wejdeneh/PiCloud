package com.esprit.edusched.controllers;

import com.esprit.edusched.services.TwilioService;
import com.esprit.edusched.services.EmailImplement;

import jakarta.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class ContactController {

    private final TwilioService twilioService;
    private final EmailImplement emailService;

    @Autowired
    public ContactController(TwilioService twilioService, EmailImplement emailService) {
        this.twilioService = twilioService;
        this.emailService = emailService;
    }

    @PostMapping("/send-sms")
    public String sendSmsNotification(@RequestBody String resource) {
        // Customize the message according to your requirements
        String message = "A new resource has been added: " + resource;

        // Replace phoneNumber with the actual phone number where you want to send the notification 
        // DONT FORGET TO VERIFY ON Twilio !!!!!!
        String phoneNumber = "+21698340515";

        // Send SMS notification using TwilioService
        twilioService.sendSms(phoneNumber, message);

        return "SMS notification sent successfully!";
    }
    
    @PostMapping("/send-email")
    public String sendEmail() {
        try {
            emailService.sendPasswordEmail("recipient@example.com"); // Replace with the recipient's email address
            return "Email sent successfully";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Failed to send email";
        }
    }
}
