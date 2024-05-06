package com.esprit.edusched.services;

import com.esprit.edusched.dto.ReservationWithOffreInfo;
import com.esprit.edusched.entities.*;

import com.esprit.edusched.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OffreRepository offreRepository;

    @Autowired
    private ReservationRepository reservationRepository;



   /* public String reserver(int idUtilisateur, int idOffre) {
        // Vérifier si l'utilisateur existe
        Optional<User> optionalUser = userRepository.findById(idUtilisateur);
        if (!optionalUser.isPresent()) {
            return "Utilisateur non trouvé";
        }
        User utilisateur = optionalUser.get();

        // Vérifier si l'offre existe
        Optional<Offre> optionalOffre = offreRepository.findById(idOffre);
        if (!optionalOffre.isPresent()) {
            return "Offre non trouvée";
        }
        Offre offre = optionalOffre.get();

        // Vérifier si l'utilisateur a déjà réservé cette offre
        boolean isAlreadyReserved = reservationRepository.existsByUserAndOffre(utilisateur, offre);
        if (isAlreadyReserved) {
            return "L'utilisateur a déjà réservé cette offre";
        }

        // Créer une nouvelle réservation
        Reservation reservation = new Reservation();
        reservation.setUser(utilisateur);
        reservation.setOffre(offre);
        //reservation.setReservationDate(new Date()); // Vous pouvez utiliser une autre méthode pour obtenir la date
        reservation.setReservationDate(LocalDateTime.now());
        reservation.setStatus(ReservationStatus.EN_ATTENTE);

        // Enregistrer la réservation dans la base de données
        reservationRepository.save(reservation);

        return "Réservation effectuée avec succès";
    }*/
   public String reserver(Long idUtilisateur, int idOffre) {
       try {
           // Vérifier si l'utilisateur existe
           Optional<User> optionalUser = userRepository.findById(idUtilisateur);
           if (!optionalUser.isPresent()) {
               return "Utilisateur non trouvé";
           }
           User utilisateur = optionalUser.get();

           // Vérifier si l'offre existe
           Optional<Offre> optionalOffre = offreRepository.findById(idOffre);
           if (!optionalOffre.isPresent()) {
               return "Offre non trouvée";
           }
           Offre offre = optionalOffre.get();

           // Vérifier si l'utilisateur a déjà réservé cette offre
           boolean isAlreadyReserved = reservationRepository.existsByUserAndOffre(utilisateur, offre);
           if (isAlreadyReserved) {
               return "L'utilisateur a déjà réservé cette offre";
           }

           // Créer une nouvelle réservation
           Reservation reservation = new Reservation();
           reservation.setUser(utilisateur);
           reservation.setOffre(offre);
           reservation.setReservationDate(LocalDateTime.now());
           reservation.setStatus(ReservationStatus.EN_ATTENTE);

           // Enregistrer la réservation dans la base de données
           reservationRepository.save(reservation);

           return "Réservation effectuée avec succès";
       } catch (Exception ex) {
           // Log the exception for debugging
           ex.printStackTrace();
           return "Une erreur s'est produite lors de la réservation";
       }
   }
    // Méthode pour confirmer une réservation
    public String confirmerReservation(int idReservation) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(idReservation);
        if (!optionalReservation.isPresent()) {
            return "Réservation non trouvée";
        }
        Reservation reservation = optionalReservation.get();
        reservation.setStatus(ReservationStatus.CONFIRMEE);
        reservationRepository.save(reservation);
        return "Réservation confirmée avec succès";
    }

    // Méthode pour refuser une réservation
    public String refuserReservation(int idReservation) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(idReservation);
        if (!optionalReservation.isPresent()) {
            return "Réservation non trouvée";
        }
        Reservation reservation = optionalReservation.get();
        reservation.setStatus(ReservationStatus.REFUSEE);
        reservationRepository.save(reservation);
        return "Réservation refusée avec succès";
    }

    public String annulerReservation(int reservationId) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            if (reservation.getStatus() == ReservationStatus.CONFIRMEE) {
                reservation.setStatus(ReservationStatus.ANNULEE);
                reservationRepository.save(reservation);
                return "Réservation annulée avec succès";
            } else {
                return "La réservation ne peut être annulée car elle n'est pas confirmée.";
            }
        } else {
            return "Réservation non trouvée";
        }
    }

    public List<Reservation> getAllReservationsWithStatus() {
        return reservationRepository.findAll();
    }



    public Reservation getReservationById(int reservationId) {
        // Use the repository to find the reservation by ID
        return reservationRepository.findById(reservationId).orElse(null);
    }

  /*  public List<ReservationWithOffreInfo> getAllReservationsWithStatusAndOffreInfo() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationWithOffreInfo> result = new ArrayList<>();
        for (Reservation reservation : reservations) {
            Offre offre = reservation.getOffre();
            if (offre != null) {
                result.add(new ReservationWithOffreInfo(reservation, offre));
            }
        }
        return result;
    }*/

    public List<ReservationWithOffreInfo> getAllReservationsWithStatusAndOffreInfo() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationWithOffreInfo> result = new ArrayList<>();
        for (Reservation reservation : reservations) {
            Offre offre = reservation.getOffre();
            if (offre != null) {
                // Fetch the affiche (image URL) from Offre and set it in ReservationWithOffreInfo
                String affiche = offre.getAffiche();
                result.add(new ReservationWithOffreInfo(reservation, offre, affiche));
            }
        }
        return result;
    }




}
