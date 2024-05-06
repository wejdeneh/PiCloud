<<<<<<< HEAD
=======

>>>>>>> origin/main
package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.ReservationC;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository

public interface ReservationCRepository extends JpaRepository<ReservationC, Long> {
<<<<<<< HEAD
=======
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
>>>>>>> origin/main
}
=======

    @Query("SELECT r FROM ReservationC r WHERE r.startd = :startd AND r.startHour = :startHour")
    List<ReservationC> findReservationsByDateAndHour(@Param("startd") LocalDate startd, @Param("startHour") LocalTime startHour);
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
