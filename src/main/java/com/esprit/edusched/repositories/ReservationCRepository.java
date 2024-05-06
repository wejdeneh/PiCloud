
package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.ReservationC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository

public interface ReservationCRepository extends JpaRepository<ReservationC, Long> {

    @Query("SELECT r FROM ReservationC r WHERE r.startd = :startd AND r.startHour = :startHour")
    List<ReservationC> findReservationsByDateAndHour(@Param("startd") LocalDate startd, @Param("startHour") LocalTime startHour);
}
