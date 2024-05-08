package com.esprit.edusched.services;

import com.esprit.edusched.dto.SignupRequest;
import com.esprit.edusched.entities.SecureToken;
import com.esprit.edusched.entities.User;
import com.esprit.edusched.repositories.SecureTokenRepository;
import com.esprit.edusched.repositories.UserRepository;
import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private  PasswordEncoder passwordEncoder;
    @Resource
    private  SecureTokenService secureTokenService;
    @Resource
    private  SecureTokenRepository secureTokenRepository;
    @Resource
    private EmailService emailService;


    @Value("${site.base.url.https}")
    private String baseURL;




    @Override
    public User createUser(SignupRequest signupRequest) throws MessagingException, UnsupportedEncodingException {
        //Check if user already exist
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(signupRequest,user);

        //Hash the pass
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        userRepository.save(user);
        sendVerificationEmail(user);
        return user;

    }

    @Override
    public void sendVerificationEmail(User user) {
        // generate an activation email token
        SecureToken secureToken= secureTokenService.createSecureToken();
        // set the token to the registered user
        secureToken.setUser(user);
        // save the token
        secureTokenRepository.save(secureToken);
        // call the email context
        AccountVerificationEmailContext emailContext = new AccountVerificationEmailContext();
        // intialise the email infos by the user infos
        emailContext.init(user);
        emailContext.setToken(secureToken.getToken());
        // build the verification url using the api generated in the controller
        emailContext.buildVerificationUrl(baseURL, secureToken.getToken());
        try {
            emailService.sendMail(emailContext);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public boolean verifyUser(String token)
    {
        SecureToken secureToken = secureTokenService.findByToken(token);
        if (Objects.isNull(secureToken) || !StringUtils.equals(token, secureToken.getToken()) || secureToken.isExpired())
        {
            throw new IllegalStateException("Invalid or expired token");
        }

        User user = userRepository.getOne(secureToken.getUser().getId());
        if (Objects.isNull(user))
        {
            return false;
        }
        user.setEnabled(true);
        userRepository.save(user); // let’s save user details

        // we don’t need invalid password now
        secureTokenService.removeToken(secureToken);
        return true;
    }




}
