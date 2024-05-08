package com.esprit.edusched.repositories;


import com.esprit.edusched.entities.Competition;
import com.esprit.edusched.entities.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition,Long> {

//    @Query("SELECT c FROM Competition c WHERE c.terrains = :terrain " +
//            "AND c.dateDebut = :dateDebut")
//    List<Competition> findCompetitionsOnSameTerrain(@Param("terrain") Terrain terrain,
//                                                    @Param("dateDebut") LocalDateTime dateDebut);
@Query("SELECT c FROM Competition c WHERE :terrain MEMBER OF c.terrains AND c.dateDebut = :dateDebut")
List<Competition> findCompetitionsOnSameTerrain(@Param("terrain") Terrain terrain,
                                                @Param("dateDebut") LocalDateTime dateDebut);

}
