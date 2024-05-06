package com.esprit.edusched.services;

import com.esprit.edusched.dto.RatingDTO;
import com.esprit.edusched.entities.*;
import com.esprit.edusched.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RatingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OffreRepository offreRepository;

    @Autowired
    private RatingRepository ratingRepository;



 /*   public Map<Offre, Integer> countRatingsByOffre(int offreId) {
        Map<Offre, Integer> offreRatingCountMap = new HashMap<>();
        List<Rating> ratings = ratingRepository.findByOffreId(offreId);
        for (Rating rating : ratings) {
            Offre offre = rating.getOffre();
            Integer count = offreRatingCountMap.getOrDefault(offre, 0);
            if (rating.getUser() != null) { // check if the rating has been modified by the same user
                offreRatingCountMap.put(offre, count);
            } else {
                offreRatingCountMap.put(offre, count + 1);
            }
        }
        return offreRatingCountMap;
    }*/





    public String deleteRating(int id) {
        if (ratingRepository.existsById(id)) {
            ratingRepository.deleteById(id);
            return "rating supprimé";
        }
        return "rating non supprimé";
    }

   /* public Rating updateRate(int id, int rating) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        if (optionalRating.isPresent()) {
            Rating ratingToUpdate = optionalRating.get();
            ratingToUpdate.setRating(rating);
            return ratingRepository.save(ratingToUpdate);
        } else {
            return null;
        }
    }*/
  /* public Rating updateRate(int id, int newRating) {
       return ratingRepository.findById(id)
               .map(existingRating -> {
                   existingRating.setRating(newRating);
                   return ratingRepository.save(existingRating);
               })
               .orElse(null);
   }*/
   public Rating updateRate(int id, RatingDTO ratingDTO) {
       Optional<Rating> ratingOptional = ratingRepository.findById(id);
       if (ratingOptional.isPresent()) {
           Rating rating = ratingOptional.get();
           rating.setRating(ratingDTO.getRating());
           Optional<User> userOptional = userRepository.findById(ratingDTO.getIdUser());
           if (userOptional.isPresent()) {
               rating.setUser(userOptional.get());
           }
           Optional<Offre> offreOptional = offreRepository.findById(ratingDTO.getIdOffre());
           if (offreOptional.isPresent()) {
               rating.setOffre(offreOptional.get());
           }
           rating.setTimestamp(new Date());
           return ratingRepository.save(rating);
       } else {
           return null;
       }
   }

    /*public String ajouter(int idUtilisateur, int idOffre, int ratingValue) {
        Optional<User> userOptional = userRepository.findById(idUtilisateur);
        Optional<Offre> offreOptional = offreRepository.findById(idOffre);

        if (userOptional.isPresent() && offreOptional.isPresent()) {
            User user = userOptional.get();
            Offre offre = offreOptional.get();

            Rating rating = new Rating();
            rating.setRating(ratingValue);
            rating.setUser(user);
            rating.setOffre(offre);

            ratingRepository.save(rating);

            return "Offer Rated";
        } else {
            return "L'utilisateur ou l'offre spécifié n'existe pas";
        }
    }*/
    public String ajouter(Long idUser, int idOffre, Integer rating) {
        Optional<User> userOptional = userRepository.findById(idUser);
        Optional<Offre> offreOptional = offreRepository.findById(idOffre);

        if (userOptional.isPresent() && offreOptional.isPresent()) {
            User user = userOptional.get();
            Offre offre = offreOptional.get();

            Rating ratingToAdd = new Rating();
            ratingToAdd.setUser(user);
            ratingToAdd.setOffre(offre);
            ratingToAdd.setRating(rating);
            ratingToAdd.setTimestamp(new Date());

            ratingRepository.save(ratingToAdd);

            return "Offre noté";
        } else {
            return "L'utilisateur ou l'offre spécifié n'existe pas";
        }
    }


    public Map<Offre, Integer> countTotalRatingsByOffre() {
        List<Rating> ratings = ratingRepository.findAll();
        Map<Offre, Integer> offreTotalRatingMap = new HashMap<>();
        Map<Long, Rating> ratingMap = new HashMap<>();
        for (Rating rating : ratings) {
            Long key = (rating.getUser().getId() << 16) | rating.getOffre().getId_offre();
            Rating existingRating = ratingMap.get(key);
            if (existingRating == null || rating.getTimestamp().after(existingRating.getTimestamp())) {
                ratingMap.put(key, rating);
            }
        }
        for (Map.Entry<Long, Rating> entry : ratingMap.entrySet()) {
            Long key = entry.getKey();
            Offre offre = offreRepository.findById((int) (key & 0xFFFF)).orElse(null);
            User user = userRepository.findById((key >> 16)).orElse(null);
            if (offre != null && user != null) {
                Integer totalRating = offreTotalRatingMap.getOrDefault(offre, 0);
                totalRating += entry.getValue().getRating();
                offreTotalRatingMap.put(offre, totalRating);
            }
        }
        return offreTotalRatingMap;
    }


}
