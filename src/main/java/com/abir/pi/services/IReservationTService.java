package com.abir.pi.services;

import com.abir.pi.entities.ReservationT;
import com.abir.pi.entities.Terrain;
import com.abir.pi.entities.User;

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
