package com.esprit.edusched.controllers;


import com.esprit.edusched.dto.EmailRequest;
import com.esprit.edusched.services.impl.EmailService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/mail")
public class EmailSendController {
   private EmailService emailService;

    public EmailSendController(EmailService emailService) {
        this.emailService = emailService;
    }

   /*@PostMapping("/send")
    public String sendMail(@RequestParam(value = "file", required = false) MultipartFile[] file, String to, String[] cc, String subject, String body) {
        return emailService.sendMail(file, to, cc, subject, body);
    }*/
   @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/email")

    public String sendMail(@RequestBody EmailRequest emailRequest) {

        return emailService.sendMail( emailRequest.getTo(), emailRequest.getCc(), emailRequest.getSubject(), emailRequest.getBody());
    }





}

