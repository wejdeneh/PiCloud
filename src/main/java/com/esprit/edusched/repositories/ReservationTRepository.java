package com.esprit.edusched.repositories;
import com.esprit.edusched.entities.ReservationT;
import com.esprit.edusched.entities.Terrain;
import com.esprit.edusched.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationTRepository extends JpaRepository<ReservationT,Integer> {
    //ReservationT findByUser(User user);
    List<ReservationT> findByUser(User user);
    List<ReservationT> findByTerrain(Terrain terrain);
}
