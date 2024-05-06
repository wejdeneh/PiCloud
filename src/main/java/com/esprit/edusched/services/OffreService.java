package com.esprit.edusched.services;

import com.esprit.edusched.dto.FrontDTO;
import com.esprit.edusched.dto.OffreDTO;
import com.esprit.edusched.entities.Offre;
import com.esprit.edusched.entities.OffreEtat;
import com.esprit.edusched.entities.Reservation;
import com.esprit.edusched.repositories.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OffreService {
    @Autowired
    private OffreRepository offreRepository;

  /*  public Offre addOffre(Offre offre) {
        return offreRepository.save(offre);
    }*/
  public Offre addOffre(Offre offre) {
      // Set default values or perform any additional logic if necessary
      offre.setEtat(OffreEtat.NON_ARCHIVE);

      // Save the Offre entity using the repository
      return offreRepository.save(offre);
  }



   /* public Offre createOffre(Offre offre) {
        return offreRepository.save(offre);
    }*/
  /* public Offre addOffre(Offre offre) {
       if (offre.getAffiche() != null) {
           offre.setAffiche(new String(Base64.getDecoder().decode(offre.getAffiche()), StandardCharsets.UTF_8));
       }
       return offreRepository.save(offre);
   }*/

    public Offre updateOffre(int id_offre, Offre newOffre) {
        return offreRepository.findById(id_offre)
                .map(existingOffre -> {
                    existingOffre.setDescription(newOffre.getDescription());
                    existingOffre.setDateOffre(newOffre.getDateOffre());
                    existingOffre.setAffiche(newOffre.getAffiche());
                    return offreRepository.save(existingOffre);
                })
                .orElse(null);
    }

    public String deleteOffre(int id_offre) {
        if (offreRepository.existsById(id_offre)) {
            offreRepository.deleteById(id_offre);
            return "offre supprimé";
        }
        return "offre non supprimé";
    }

    public List<OffreDTO> getOffresListe() {
        //findOffresByReservationsIsNull();
        //List<Offre> offres = offreRepository.findAll();
        List<Offre> offres = offreRepository.findByEtat(OffreEtat.NON_ARCHIVE);
        return offres.stream()
                .map(offre -> new OffreDTO(offre.getId_offre(),offre.getDescription(), offre.getDateOffre(), offre.getAffiche(),offre.getEtat()))
                .collect(Collectors.toList());
    }

  /*  public List<FrontDTO> getOffresDescriptionAndDate() {
        List<Offre> offres = offreRepository.findAll();
        return offres.stream()
                .map(offre -> new FrontDTO(offre.getId_offre(), offre.getDescription(), offre.getDateOffre(), offre.getAffiche()))
                .collect(Collectors.toList());
    }*/
  public List<FrontDTO> getOffresDescriptionAndDate() {
      List<Offre> offres = offreRepository.findByEtat(OffreEtat.NON_ARCHIVE);
      return offres.stream()
              .map(offre -> new FrontDTO(offre.getId_offre(), offre.getDescription(), offre.getDateOffre(), offre.getAffiche(), offre.getEtat()))
              .collect(Collectors.toList());
  }

    public List<Reservation> getReservationsByOffreId(int offreId) {
        Offre offre = offreRepository.findById(offreId).orElseThrow(() -> new ResourceNotFoundException("Offre not found"));
        return offre.getReservations();
    }

    public void archiveOffre(int idOffre) {
        Offre offre = offreRepository.findById(idOffre).orElse(null);
        if (offre != null && offre.getEtat() == OffreEtat.NON_ARCHIVE) {
            offre.setEtat(OffreEtat.ARCHIVE);
            offreRepository.save(offre);
        }
    }

    public List<FrontDTO> getArchive() {
        List<Offre> offres = offreRepository.findByEtat(OffreEtat.ARCHIVE);
        return offres.stream()
                .map(offre -> new FrontDTO(offre.getId_offre(), offre.getDescription(), offre.getDateOffre(), offre.getAffiche(), offre.getEtat()))
                .collect(Collectors.toList());
    }
    public void desarchiver(int idOffre) {
        Offre offre = offreRepository.findById(idOffre).orElse(null);
        if (offre != null && offre.getEtat() == OffreEtat.ARCHIVE) {
            offre.setEtat(OffreEtat.NON_ARCHIVE);
            offreRepository.save(offre);
        }
    }

    public List<OffreDTO> getArchiveCoach() {
        List<Offre> offres = offreRepository.findByEtat(OffreEtat.ARCHIVE);
        return offres.stream()
                .map(offre -> new OffreDTO(offre.getId_offre(), offre.getDescription(), offre.getDateOffre(), offre.getAffiche(), offre.getEtat()))
                .collect(Collectors.toList());
    }

    public List<OffreDTO> getOffresAVenir() {
        // Récupérer la date actuelle
        Date dateActuelle = new Date();

        // Récupérer les offres à venir (avec une date ultérieure à la date actuelle)
        List<Offre> offresAVenir = offreRepository.findByDateOffreAfter(dateActuelle);

        // Mapper les offres à un DTO et les retourner
        return offresAVenir.stream()
                .map(offre -> new OffreDTO(offre.getId_offre(), offre.getDescription(), offre.getDateOffre(), offre.getAffiche(), offre.getEtat()))
                .collect(Collectors.toList());
    }

    public List<OffreDTO> getOffresPassees() {
        // Récupérer la date actuelle
        Date dateActuelle = new Date();

        // Récupérer les offres passées (avec une date antérieure ou égale à la date actuelle)
        List<Offre> offresPassees = offreRepository.findByDateOffreBefore(dateActuelle);

        // Mapper les offres à un DTO et les retourner
        return offresPassees.stream()
                .map(offre -> new OffreDTO(offre.getId_offre(), offre.getDescription(), offre.getDateOffre(), offre.getAffiche(), offre.getEtat()))
                .collect(Collectors.toList());
    }


}
