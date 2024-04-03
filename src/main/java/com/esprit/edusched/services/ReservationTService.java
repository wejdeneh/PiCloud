package com.esprit.edusched.services;

import com.esprit.edusched.entities.ReservationT;
import com.esprit.edusched.repositories.ReservationTRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationTService implements IReservationTService{
    @Autowired
    private ReservationTRepository reservationTRepository;
    @Override
    public ReservationT addReservationT(ReservationT resT) {
        return reservationTRepository.save(resT);
    }

    @Override
    public ReservationT updateReservationT(int idRestT,ReservationT resT) {
        return reservationTRepository.save(resT);
    }

    @Override
    public void deleteReservationT(int idResT) {
        reservationTRepository.deleteById(idResT);

    }


    @Override
    public List<ReservationT> findAllReservationsT() {
        return reservationTRepository.findAll();
    }

    @Override
    public ReservationT findReservationTById(int idResT) {
        return reservationTRepository.findById(idResT).get();
    }
}
