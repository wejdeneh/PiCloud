package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
    //User findByEmail1(String email);


}