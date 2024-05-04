package com.esprit.edusched.utils;

import com.esprit.edusched.entities.User;

import com.esprit.edusched.repositories.RoleRepository;
import com.esprit.edusched.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class AdminAccountRemover implements ApplicationListener<ContextClosedEvent> {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public AdminAccountRemover(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextClosedEvent event) {
        Optional<User> adminOptional = userRepository.findByEmail("admin@example.com");
        if (adminOptional.isPresent()) {
            User admin = adminOptional.get();
            roleRepository.deleteByUser(admin);
            userRepository.delete(admin);
        }
    }
}
