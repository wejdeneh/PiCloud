package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.SecureToken;
import com.esprit.edusched.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SecureTokenRepository extends JpaRepository<SecureToken,Long> {
    SecureToken findByToken(String token);
    void removeByToken(String token);
    List<SecureToken> findAll();
    Optional< SecureToken > findByUser(User user);
}