package com.esprit.edusched.repositories;



import com.esprit.edusched.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    // You can add custom query methods if needed
    @Query("SELECT r.comment FROM Review r")
    List<String> findAllComments();

   // List<String> findCommentsById_offre(int id_offre);
}

