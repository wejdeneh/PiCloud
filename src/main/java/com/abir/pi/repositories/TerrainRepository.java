package com.abir.pi.repositories;

import com.abir.pi.entities.ReservationT;
import com.abir.pi.entities.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TerrainRepository extends JpaRepository<Terrain,Integer> {
    /*public Date findFirstDate(ReservationT reservationT);

    public Date findLastDate(ReservationT reservationT);

    public void findBetween(Date from, Date to);*/

}
