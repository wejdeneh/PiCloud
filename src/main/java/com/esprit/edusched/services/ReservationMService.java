package com.esprit.edusched.services;




import com.esprit.edusched.entities.ReservationM;
import com.esprit.edusched.repositories.ReservationMRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationMService implements IReservationMService{
    @Autowired
    private ReservationMRepository reservationMRepository;
    @Override
    public ReservationM addReservationM(ReservationM resM) {
        return reservationMRepository.save(resM);
    }

    @Override
    public ReservationM updateReservationM(int idRestM, ReservationM resM) {
        return reservationMRepository.save(resM);
    }

    @Override
    public void deleteReservationM(int idResM) {
        reservationMRepository.deleteById(idResM);

    }

    @Override
    public List<ReservationM> findAllReservationsM() {
        System.out.println("i am here ");

        return reservationMRepository.findAll();
       }

    @Override
    public ReservationM findReservationMById(int idResM) {
        return reservationMRepository.findById(idResM).get();
    }
}
