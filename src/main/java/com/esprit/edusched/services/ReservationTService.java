package com.esprit.edusched.services;
import com.esprit.edusched.entities.ReservationT;
import com.esprit.edusched.entities.Terrain;
import com.esprit.edusched.entities.User;
import com.esprit.edusched.enums.Etat;
import com.esprit.edusched.repositories.ReservationTRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return reservationTRepository.findAll();
    }

    @Override
    public ReservationT findReservationTById(int idResT) {
        return reservationTRepository.findById(idResT).get();
    }
    public boolean reserver(int idResT,User user){
        ReservationT reservationT = reservationTRepository.findById(idResT).get();
        reservationT.setUser(user);
        reservationT.setEtat(Etat.RESERVED);
        reservationTRepository.save(reservationT);
        return true;
    }
    public List<ReservationT> getAvailableReservations(){
        List<ReservationT> allReservations = reservationTRepository.findAll();
        List<ReservationT> availableReservations = allReservations.stream().filter(reservationT -> reservationT.getEtat()==Etat.AVAILABLE).collect(Collectors.toList());
        return availableReservations;
    }
    public List<ReservationT> getReservationByUser(User user){
        return reservationTRepository.findByUser(user);
    }
    public List<ReservationT> getReservationByTerrain(Terrain terrain){
        return reservationTRepository.findByTerrain(terrain);
    }



}
