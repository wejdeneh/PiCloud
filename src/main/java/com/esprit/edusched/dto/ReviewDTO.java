package com.esprit.edusched.dto;




public class ReviewDTO {
    private String comment;
    private Long userId; // Add user ID field
    private int offreId; // Add offre ID field

    // Constructors, getters, and setters
    // Constructor
    public ReviewDTO() {
    }

    public ReviewDTO(String comment, Long userId, int offreId) {
        this.comment = comment;
        this.userId = userId;
        this.offreId = offreId;
    }

    // Getters and setters
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getOffreId() {
        return offreId;
    }

    public void setOffreId(int offreId) {
        this.offreId = offreId;
    }
}
