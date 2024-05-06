package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
  //  List<Rating> findByOffreId(int offreId);
}
