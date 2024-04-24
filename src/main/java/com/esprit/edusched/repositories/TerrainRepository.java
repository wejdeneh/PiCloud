package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerrainRepository extends JpaRepository<Terrain,Integer> {
    /*public Date findFirstDate(ReservationT reservationT);

    public Date findLastDate(ReservationT reservationT);

    public void findBetween(Date from, Date to);*/

}
