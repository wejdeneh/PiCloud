package com.esprit.edusched.utils;

import com.esprit.edusched.entities.Role;
import com.esprit.edusched.entities.User;
import com.esprit.edusched.entities.enumRole;
import com.esprit.edusched.repositories.RoleRepository;
import com.esprit.edusched.repositories.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminAccountInitializer implements ApplicationRunner {
@Resource
    private final UserRepository userRepository;
    @Resource

    private final RoleRepository roleRepository;
    @Resource

    private final PasswordEncoder passwordEncoder;


    public AdminAccountInitializer(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Vérifiez si le compte admin existe déjà
        if (!userRepository.existsByEmail("admin@example.com")) {
            // Créez un nouvel utilisateur admin
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("King123")); // Encodez le mot de passe

            // Enregistrez l'utilisateur admin dans la base de données
            admin = userRepository.save(admin);

            // Créez un rôle pour l'administrateur
            Role adminRole = new Role();
            adminRole.setRole(enumRole.ADMIN);
            adminRole.setUser(admin);

            // Enregistrez le rôle dans la base de données
            roleRepository.save(adminRole);
        }
    }
}
