package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.React;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactRepository extends JpaRepository<React, Long> {

  //  Optional<React> findByOffreId(int offreId);
}
