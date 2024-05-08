package com.esprit.edusched.services.jwt;

import com.esprit.edusched.entities.User;
import com.esprit.edusched.services.EmailService;
import com.esprit.edusched.repositories.UserRepository;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Slf4j
public class UserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private EmailService emailService;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email"+ email));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), Collections.emptyList());
    }


    public String forgotPassword(String email) throws MessagingException {

//        if(details!=null){
//            emailService.sendPasswordEmail(email);
//            System.out.println("yes");
//        return "please check your email to set new password";}
            return "no match for user";
    }
}
