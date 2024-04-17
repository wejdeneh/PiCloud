package com.esprit.edusched.services;

import com.esprit.edusched.entities.ReservationC;
import com.esprit.edusched.repositories.ReservationCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationCService {
    @Autowired
    private ReservationCRepository reservationCRepository;

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

    public String deleteReservationC(Long id) {
        if (reservationCRepository.existsById(id)) {
            reservationCRepository.deleteById(id);
            return "ReservationC deleted";
        }
        return "ReservationC not found";
    }
}
