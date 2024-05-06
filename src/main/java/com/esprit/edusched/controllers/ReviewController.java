package com.esprit.edusched.controllers;


import com.esprit.edusched.dto.ReviewDTO;
import com.esprit.edusched.entities.Review;
import com.esprit.edusched.repositories.ReviewRepository;
import com.esprit.edusched.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Review> addReview(@RequestBody ReviewDTO reviewDTO) {
        Review createdReview = reviewService.addReview(reviewDTO);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }


    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable("reviewId") int reviewId,
                                               @RequestBody String newComment) {
        Review updatedReview = reviewService.updateReviewComment(reviewId, newComment);
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable("id") int id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get comments only without IDs
    @GetMapping("/comments")
    public List<String> getCommentsOnly() {
        return reviewRepository.findAllComments();
    }

  /* @GetMapping("/comments/{id_offre}")
    public List<String> findCommentsById_offre(@PathVariable int id_offre) {
        return reviewRepository.findCommentsById_offre(id_offre);
    }*/

}

