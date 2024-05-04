package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.Role;
import com.esprit.edusched.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    void deleteByUser(User admin);
}
