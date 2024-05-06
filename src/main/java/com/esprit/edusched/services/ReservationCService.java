package com.esprit.edusched.services;

import com.esprit.edusched.entities.Class;
import com.esprit.edusched.entities.ReservationC;
import com.esprit.edusched.repositories.ClassRepository;
import com.esprit.edusched.repositories.ReservationCRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.ZoneId;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ReservationCService {
    private final ReservationCRepository reservationCRepository;
    private final ClassRepository classRep;
    private final SmsService smsService;
    private final String phoneNumber = "+21628275170";

    public ReservationC addReservationC(ReservationC reservationC) {
        return reservationCRepository.save(reservationC);
    }

    public List<ReservationC> getAllReservationCs() {

        return reservationCRepository.findAll();
    }

    public ReservationC getReservationCById(Long id) {
        return reservationCRepository.findById(id).orElse(null);
    }

    public ReservationC updateReservationC(Long id, ReservationC updatedReservationC) {
        ReservationC reservationC = reservationCRepository.findById(id).orElse(null);
        if (reservationC != null) {
            reservationC.setStartd(updatedReservationC.getStartd());
            reservationC.setFinald(updatedReservationC.getFinald());
            reservationC.setState(updatedReservationC.getState());
            reservationC.setClas(updatedReservationC.getClas());
            return reservationCRepository.save(reservationC);
        }
        return null;
    }
    public ReservationC updateReservationState(Long id, String newState) {
        ReservationC reservationC = reservationCRepository.findById(id).orElse(null);
        if (reservationC != null) {
            reservationC.setState(newState);
            String smsMessage = "Your reservation at " + reservationC.getStartd() + " is "+ newState;
//            smsService.sendSms(String.valueOf(user.getNumTel()), smsMessage, newState);
           smsService.sendSms(phoneNumber, smsMessage);
            return reservationCRepository.save(reservationC);

        }
        return null; // Or throw an exception if the reservation with the given id is not found
    }

    public String deleteReservationC(Long id) {
        if (reservationCRepository.existsById(id)) {
            reservationCRepository.deleteById(id);
            return "ReservationC deleted";
        }
        return "ReservationC not found";
    }
    @Transactional
    public void addReservationAffectClass(ReservationC res, Long idC) {
        Class clas = classRep.findById(idC).orElse(null);
        if (clas == null) {
            log.error("Class not found with ID: " + idC);
            return;
        }

        log.info("Attempting to add a new reservation: StartDate={}, FinalDate={}, StartHour={}, FinalHour={}",
                res.getStartd(), res.getFinald(), res.getStartHour(), res.getFinalHour());

        // Use the custom repository method to find reservations by date and hour
        List<ReservationC> existingReservations = reservationCRepository.findReservationsByDateAndHour(
                res.getStartd(), res.getStartHour());

        boolean hasOverlap = existingReservations.stream().anyMatch(existingRes ->
                !(res.getFinald().isBefore(existingRes.getStartd()) || res.getStartd().isAfter(existingRes.getFinald())) &&
                        !(res.getFinalHour().isBefore(existingRes.getStartHour()) || res.getStartHour().isAfter(existingRes.getFinalHour()))
        );

        if (!hasOverlap) {
            res.setClas(clas);
            reservationCRepository.saveAndFlush(res); // Note the flush here
            log.info("Reservation added successfully for class ID: " + idC);
            //String smsMessage = "Your reservation has been submited.";
            //            smsService.sendSms(String.valueOf(user.getNumTel()), smsMessage);
           // smsService.sendSms(phoneNumber, smsMessage);

        } else {
            log.error("Failed to add reservation due to a conflict with existing reservations for class ID: " + idC);
        }
    }


}

