package com.esprit.edusched.repositories;
import com.esprit.edusched.entities.ReservationT;
import com.esprit.edusched.entities.Terrain;
import com.esprit.edusched.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationTRepository extends JpaRepository<ReservationT,Integer> {
    //ReservationT findByUser(User user);
    List<ReservationT> findByUser(User user);
    List<ReservationT> findByTerrain(Terrain terrain);
}
