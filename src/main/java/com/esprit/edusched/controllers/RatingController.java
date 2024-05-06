package com.esprit.edusched.controllers;

import com.esprit.edusched.dto.RatingDTO;
import com.esprit.edusched.entities.Offre;
import com.esprit.edusched.entities.Rating;
import com.esprit.edusched.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/rate")
public class RatingController {

    @Autowired
    private RatingService ratingService;



   /* @PostMapping("/ajout")
    public ResponseEntity<String> ajouter(@RequestParam int idUtilisateur, @RequestParam int idOffre, @RequestParam(required = false) Integer ratingValue) {
        if (ratingValue == null) {
            return ResponseEntity.badRequest().body("La valeur de rating est obligatoire");
        }

        String result = ratingService.ajouter(idUtilisateur, idOffre, ratingValue);
        if (result.equals("Offer rated")) {
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }*/
   @PostMapping("/ajout")
   public ResponseEntity<String> ajouter(@RequestBody RatingDTO ratingDTO) {
       if (ratingDTO.getRating() == 0) {
           return ResponseEntity.badRequest().body("La valeur de rating est obligatoire");
       }

       String result = ratingService.ajouter(ratingDTO.getIdUser(), ratingDTO.getIdOffre(), ratingDTO.getRating());
       if (result.equals("Offre noté")) {
           return ResponseEntity.ok().body(result);
       } else {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
       }
   }

  /*  @GetMapping("/offre/{offreId}")
    public ResponseEntity<Map<Offre, Integer>> countRatingsByOffre(@PathVariable int offreId) {
        return ResponseEntity.ok(ratingService.countRatingsByOffre(offreId));
    }*/

  /*  @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> updateRating(@PathVariable int id, @RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.updateRating(id, rating));
    }*/



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOffre(@PathVariable int id) {
        // Appelez la méthode deleteOffre du service
        String result = ratingService.deleteRating(id);
        if (result.equals("rating supprimé")) {
            //return ResponseEntity.ok().build();
            return ResponseEntity.ok("Rating a été supprimée avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L'offre avec l'ID " + id + " n'a pas été trouvée.");
        }
    }



   /* @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Rating> updateRate(@PathVariable(value = "id") int id,
                                             @RequestParam(value = "rating") int rating) {
        Rating updateRate = ratingService.updateRate(id, rating);
        if (updateRate != null) {
            return ResponseEntity.ok(updateRate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/


    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Rating> updateRate(@PathVariable(value = "id") int id,
                                             @RequestBody RatingDTO ratingDTO) {
        Rating rating = ratingService.updateRate(id, ratingDTO);
        if (rating != null) {
            return ResponseEntity.ok(rating);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/total")
    public Map<Offre, Integer> countTotalRatingsByOffre() {
        return ratingService.countTotalRatingsByOffre();
    }
}
