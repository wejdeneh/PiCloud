package com.esprit.edusched.services;
import com.esprit.edusched.entities.ReservationT;

import java.util.List;

public interface IReservationTService {
    ReservationT addReservationT(ReservationT resT);
    ReservationT updateReservationT(int idResT,ReservationT resT);

    void deleteReservationT(int idResT);
    List<ReservationT> findAllReservationsT();
    ReservationT findReservationTById(int idResT);


}
