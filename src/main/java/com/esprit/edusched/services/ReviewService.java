package com.esprit.edusched.services;



import com.esprit.edusched.dto.ReviewDTO;
import com.esprit.edusched.entities.*;

import com.esprit.edusched.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    private OffreRepository offreRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(ReviewDTO reviewDTO) {
        // Retrieve user and offre entities based on their IDs
        User user = userRepository.findById(reviewDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Offre offre = offreRepository.findById(reviewDTO.getOffreId())
                .orElseThrow(() -> new IllegalArgumentException("Offre not found"));

        // Create a new review entity
        Review review = new Review();
        review.setComment(reviewDTO.getComment());
        review.setUser(user);
        review.setOffre(offre);

        // Save the review
        return reviewRepository.save(review);
    }

    public Review updateReviewComment(int reviewId, String newComment) {
        // Retrieve the existing review entity
        Review existingReview = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("Review not found"));

        // Update the comment of the review entity
        existingReview.setComment(newComment);

        // Save the updated review
        return reviewRepository.save(existingReview);
    }

    public void deleteReview(int id) {
        // Implement logic to delete review by id
        reviewRepository.deleteById(id);
    }

    /*public List<String> findCommentsById_offre(int id_offre) {
        return reviewRepository.findCommentsById_offre(id_offre);
    }*/
}
