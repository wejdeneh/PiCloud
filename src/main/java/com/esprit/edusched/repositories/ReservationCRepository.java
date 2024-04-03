package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.ReservationC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReservationCRepository extends JpaRepository<ReservationC, Long> {
}
