package com.esprit.edusched.controllers;


import com.esprit.edusched.dto.ReservationDTO;
import com.esprit.edusched.dto.ReservationRequestDTO;
import com.esprit.edusched.dto.ReservationWithOffreInfo;
import com.esprit.edusched.dto.UserDTO;
import com.esprit.edusched.entities.Reservation;
import com.esprit.edusched.entities.User;
import com.esprit.edusched.repositories.OffreRepository;
import com.esprit.edusched.repositories.ReservationRepository;
import com.esprit.edusched.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    @Autowired
    private OffreRepository offreRepository;
    @Autowired
    private ReservationRepository reservationRepository;


   /* @PostMapping("/reserve")
    public ResponseEntity<String> reserver(@RequestParam int idUtilisateur, @RequestParam int idOffre) {
        String result = reservationService.reserver(idUtilisateur, idOffre);
        if (result.equals("Réservation effectuée avec succès")) {
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }*/
   @PostMapping("/reserve")
   public ResponseEntity<ReservationDTO> reserver(@RequestBody ReservationRequestDTO requestDTO) {
       Long idUtilisateur = requestDTO.getIdUtilisateur();
       int idOffre = requestDTO.getIdOffre();

       String result = reservationService.reserver(idUtilisateur, idOffre);
       // Log the result for debugging
       System.out.println("Reservation Result: " + result);

       if (result.equals("Réservation effectuée avec succès")) {
           // Assuming you have a method to fetch the reservation details
           ReservationDTO reservationDTO = fetchReservationDetails(idUtilisateur, idOffre);
           return ResponseEntity.ok().body(reservationDTO);
       } else {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
       }
   }
    private ReservationDTO fetchReservationDetails(Long idUtilisateur, int idOffre) {
        // Logic to fetch reservation details from the database
        // You may need to implement this logic based on your application's requirements

        // For now, return a dummy value
        return new ReservationDTO();
    }




    // Endpoint pour confirmer une réservation
    @PutMapping("/confirm/{id}")
    public ResponseEntity<String> confirmerReservation(@PathVariable("id") int idReservation) {
        String message = reservationService.confirmerReservation(idReservation);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // Endpoint pour refuser une réservation
    @PutMapping("/reject/{id}")
    public ResponseEntity<String> refuserReservation(@PathVariable("id") int idReservation) {
        String message = reservationService.refuserReservation(idReservation);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<String> annulerReservation(@PathVariable("id") int reservationId) {
        String message = reservationService.annulerReservation(reservationId);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservationsWithStatus() {
        return reservationService.getAllReservationsWithStatus();
    }



    @GetMapping("/{reservationId}/user")
    public ResponseEntity<UserDTO> getUserDetailsForReservation(@PathVariable int reservationId) {
        // Assume you have a method in the service layer to get reservation details by ID
        Reservation reservation = reservationService.getReservationById(reservationId);

        // Check if the reservation exists
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }

        // Get the user associated with the reservation
        User user = reservation.getUser();

        // Check if the user exists
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        // Map the user to a UserDTO object containing only the name and email
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        return ResponseEntity.ok(userDTO);
    }


    @GetMapping("/front")
    public List<ReservationWithOffreInfo> getAllReservationsFront() {
        return reservationService.getAllReservationsWithStatusAndOffreInfo();
    }




}
