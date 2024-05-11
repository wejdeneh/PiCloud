package com.abir.pi.repositories;

import com.abir.pi.entities.ReservationT;
import com.abir.pi.entities.Terrain;
import com.abir.pi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationTRepository extends JpaRepository<ReservationT,Integer> {
    //ReservationT findByUser(User user);
    List<ReservationT> findByUser(User user);
    List<ReservationT> findByTerrain(Terrain terrain);
}
