package com.esprit.edusched.repositories;
import com.esprit.edusched.entities.Offre;
import com.esprit.edusched.entities.Reservation;
import com.esprit.edusched.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    boolean existsByUserAndOffre(User user, Offre offre);

}

