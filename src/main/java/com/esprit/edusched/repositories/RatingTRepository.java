package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.Rating;
import com.esprit.edusched.entities.RatingT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingTRepository extends JpaRepository <RatingT,Integer> {

}