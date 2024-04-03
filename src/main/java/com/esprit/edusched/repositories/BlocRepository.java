package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BlocRepository extends JpaRepository<Bloc, Long> {
}
