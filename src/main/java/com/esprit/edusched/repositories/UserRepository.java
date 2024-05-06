package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
