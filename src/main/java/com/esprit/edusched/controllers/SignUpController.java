package com.esprit.edusched.controllers;

import com.esprit.edusched.dto.SignupRequest;
import com.esprit.edusched.entities.User;
import com.esprit.edusched.services.AuthService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/signup")
public class SignUpController {

    private final AuthService authService;

    @Autowired
    public SignUpController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping
    public ResponseEntity<?> singupUser(@RequestBody SignupRequest signupRequest) throws MessagingException, UnsupportedEncodingException {

        User isUserCreated = authService.createUser(signupRequest);
        if (isUserCreated != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(isUserCreated);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed to create");
        }
    }
    @GetMapping("register/verify")
    public String verifyCustomer(@RequestParam(required = false) String token)
    {
        authService.verifyUser(token);
        return "Done";
    }

}
