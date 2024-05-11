package com.abir.pi.services;

import com.abir.pi.entities.ReservationT;
import com.abir.pi.entities.Terrain;
import com.abir.pi.entities.User;
import com.abir.pi.enums.Etat;
import com.abir.pi.repositories.ReservationTRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        List<ReservationT> reservations = reservationTRepository.findAll();
        reservations.forEach(reservation -> reservation.setUser(null)); // This line sets the user to null for each reservation
        return reservations;
        //return reservationTRepository.findAll();
    }
    public List<ReservationT> findAll() {
        return reservationTRepository.findAll();
    }

    @Override
    public ReservationT findReservationTById(int idResT) {
        return reservationTRepository.findById(idResT).get();
    }
    public boolean reserver(int idResT,User user){
        System.out.println(user);
        ReservationT reservationT = reservationTRepository.findById(idResT).get();
        reservationT.setUser(user);
        reservationT.setEtat(Etat.RESERVED);
        reservationTRepository.save(reservationT);
        return true;
    }
    @Override
    public ReservationT reserve(ReservationT t,User user){
        t.setUser(user);
        return reservationTRepository.save(t);
    }

    public List<ReservationT> getAvailableReservations(){
        List<ReservationT> allReservations = reservationTRepository.findAll();
        List<ReservationT> availableReservations = allReservations.stream().filter(reservationT -> reservationT.getEtat()==Etat.AVAILABLE).collect(Collectors.toList());
        availableReservations.forEach(reservation -> reservation.setUser(null));
        return availableReservations;
    }
    public List<ReservationT> getReservationByUser(User user){
        return reservationTRepository.findByUser(user);
    }
    public List<ReservationT> getReservationByTerrain(Terrain terrain){
        return reservationTRepository.findByTerrain(terrain);
    }


}
