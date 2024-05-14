package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.Bloc;
import com.esprit.edusched.entities.User;
import com.esprit.edusched.repositories.BlocRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);


    Optional<User> findByEmail(String email);


    List<User> findByBannedTrue();
    //User findByEmail1(String email);

    @Query("SELECT FUNCTION('MONTH', u.creationDate) AS month, COUNT(u) AS count FROM User u GROUP BY FUNCTION('MONTH', u.creationDate)")
    List<Object[]> countUsersByRegistrationMonth();
    
}

