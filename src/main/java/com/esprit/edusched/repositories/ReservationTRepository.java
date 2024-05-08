package com.esprit.edusched.repositories;
import com.esprit.edusched.entities.ReservationT;
import com.esprit.edusched.entities.Terrain;
import com.esprit.edusched.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ReservationTRepository extends JpaRepository<ReservationT,Integer> {
    //ReservationT findByUser(User user);
    List<ReservationT> findByUser(User user);
    List<ReservationT> findByTerrain(Terrain terrain);




    @Query("SELECT r FROM ReservationT r WHERE r.terrain = :terrain " +
            "AND ((r.date_debut BETWEEN :dateDebut AND :dateFin) OR " +
            "(r.date_fin BETWEEN :dateDebut AND :dateFin) OR " +
            "(:dateDebut BETWEEN r.date_debut AND r.date_fin) OR " +
            "(:dateFin BETWEEN r.date_debut AND r.date_fin))")
    List<ReservationT> findConflictingReservations(@Param("terrain") Terrain terrain,
                                                   @Param("dateDebut") Date dateDebut,
                                                   @Param("dateFin") Date dateFin);
    @Query("SELECT COUNT(r) > 0 FROM ReservationT r WHERE r.terrain = :terrain " +
            "AND r.etat = com.esprit.edusched.enums.Etat.RESERVED " +
            "AND ((:startDate BETWEEN r.date_debut AND r.date_fin) " +
            "OR (:endDate BETWEEN r.date_debut AND r.date_fin) " +
            "OR (r.date_debut BETWEEN :startDate AND :endDate) " +
            "OR (r.date_fin BETWEEN :startDate AND :endDate))")
    boolean isTerrainReservedExcludingDates(Terrain terrain, LocalDateTime startDate, LocalDateTime endDate);
}
