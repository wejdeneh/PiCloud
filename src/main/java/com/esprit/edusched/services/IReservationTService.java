package com.esprit.edusched.services;
import com.esprit.edusched.entities.ReservationT;
import com.esprit.edusched.entities.User;

import java.util.Date;
import java.util.List;

public interface IReservationTService {
    ReservationT addReservationT(ReservationT resT);
    ReservationT updateReservationT(int idResT,ReservationT resT);

    void deleteReservationT(int idResT);
    List<ReservationT> findAllReservationsT();
    List<ReservationT> findAll();

    ReservationT findReservationTById(int idResT);
    public ReservationT reserve(ReservationT t, User user);


}
