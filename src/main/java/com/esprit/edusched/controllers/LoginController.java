package com.esprit.edusched.controllers;

import com.esprit.edusched.dto.LoginRequest;
import com.esprit.edusched.dto.LoginResponse;
import com.esprit.edusched.services.jwt.UserServiceImpl;
import com.esprit.edusched.utils.JwtUtil;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;
    private final JwtUtil jwtUtil;
    @Autowired
    public LoginController(AuthenticationManager authenticationManager, UserServiceImpl userService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }
    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword())
            );
        } catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        UserDetails userDetail;
        try {
            userDetail = userService.loadUserByUsername(loginRequest.getEmail());
        } catch(UsernameNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        String jwt = jwtUtil.generateToken(userDetail.getUsername());
        return ResponseEntity.ok(new LoginResponse(jwt,userDetail.getUsername()));
    }

    @PostMapping ("/forget")
    public ResponseEntity<?> forgot_pass(@RequestBody String email) throws MessagingException {
        userService.forgotPassword(email);
        return ResponseEntity.ok("accepted");
    }
}
