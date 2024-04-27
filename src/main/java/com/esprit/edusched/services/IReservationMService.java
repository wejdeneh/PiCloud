package com.esprit.edusched.services;
import com.esprit.edusched.entities.ReservationM;


import java.util.List;

public interface IReservationMService {
    ReservationM addReservationM(ReservationM resM);
    ReservationM updateReservationM(int idResM,ReservationM resM);
    void deleteReservationM(int idResM);
    List<ReservationM> findAllReservationsM();
    ReservationM findReservationMById(int idResM);

}
