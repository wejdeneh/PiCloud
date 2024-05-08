package com.esprit.edusched.services.jwt;

import com.esprit.edusched.entities.User;
import com.esprit.edusched.repositories.UserRepository;
import com.esprit.edusched.services.EmailImplement;
import com.esprit.edusched.services.EmailService;
import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserDetailsService {
    @Resource
    private  UserRepository userRepository;
    @Resource
    private  EmailService emailService;
    private static final int TOKEN_LENGTH = 32;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email"+ email));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), Collections.emptyList());
    }


    public void initiatePasswordReset(String email) throws MessagingException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        emailService.sendPasswordEmail(email);
    }

    public void banUser(String email, int banDurationInDays) {
        System.out.println(email);
        Optional<User> optionalUser = userRepository.findByEmail(email);
        System.out.println(optionalUser);
        optionalUser.ifPresent(user -> {
            user.setBanned(true);
            user.setBanExpirationDate(new Date(System.currentTimeMillis() + banDurationInDays * 24 * 60 * 60 * 1000));
            System.out.println(user.getBanExpirationDate());
            userRepository.save(user);
        });
    }

    public void unbanUser(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        optionalUser.ifPresent(user -> {
            user.setBanned(false);
            user.setBanExpirationDate(null);
            userRepository.save(user);
        });
    }

    public boolean isUserBanned(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser.map(User::isBanned).orElse(false);
    }


}
