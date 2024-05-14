package com.esprit.edusched.repositories;

import com.esprit.edusched.dto.OffreDTO;
import com.esprit.edusched.entities.Offre;
import com.esprit.edusched.entities.OffreEtat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OffreRepository extends JpaRepository<Offre, Integer>{
   @Query("SELECT new com.esprit.edusched.dto.OffreDTO(o.id_offre,o.description, o.dateOffre,o.affiche,o.etat) FROM Offre o")
    List<OffreDTO> getOffresListe();


    List<Offre> findOffresByReservationsIsNull();
    List<Offre> findByEtat(OffreEtat etat);

    // Méthode pour récupérer les offres avec une date ultérieure à la date actuelle
    List<Offre> findByDateOffreAfter(Date date);

    // Méthode pour récupérer les offres avec une date antérieure ou égale à la date actuelle
    List<Offre> findByDateOffreBefore(Date date);

}
