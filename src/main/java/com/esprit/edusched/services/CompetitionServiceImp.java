package com.esprit.edusched.services;


import com.esprit.edusched.dto.saveReservationDTO;
import com.esprit.edusched.entities.Competition;
import com.esprit.edusched.entities.ReservationT;
import com.esprit.edusched.entities.Team;
import com.esprit.edusched.entities.Terrain;
import com.esprit.edusched.enums.Etat;
import com.esprit.edusched.repositories.CompetitionRepository;
import com.esprit.edusched.repositories.ReservationTRepository;
import com.esprit.edusched.repositories.TeamRepository;
import com.esprit.edusched.repositories.TerrainRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
@Slf4j
public class CompetitionServiceImp implements CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TerrainRepository terrainRepository;

    @Autowired
    private ReservationTRepository reservationTRepository;

    @Override
    public Competition addCompetition(Competition competition) {
//        String qrData = "Competition Details:" + competition.getCompetitionId() + " ,Nom:" + competition.getNom() + " ,Date :" + competition.getDateDebut() + " ,Catégorie :" + competition.getCategorie();
        String qrData = "Competition Details:" + competition.getCompetitionId() + " ,Nom:" + competition.getNom() + " ,Catégorie :" + competition.getCategorie();
        String qrCodeUrl = generateQRCode(qrData);
        competition.setQrcode(qrCodeUrl);
        return competitionRepository.save(competition);
    }

    @Override
    public Competition updateCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    @Override
    public void deleteCompetition(Competition competition) {
        competitionRepository.delete(competition);


    }

    @Override
    public Competition fingById(Long id) {
        if (id != null) {
            final Optional<Competition> optionalCompetition = competitionRepository.findById(id);
            if (optionalCompetition.isPresent()) {
                return optionalCompetition.get();
            }

        }
        return null;

    }

    @Override
    public void affecterCompetitionAEquipe(long idCompetition, long idTeam) {
        Team equipe = teamRepository.findById(idTeam).orElseThrow(() -> new EntityNotFoundException("Equipe non trouvée"));
        Competition competition = competitionRepository.findById(idCompetition).orElseThrow(() -> new EntityNotFoundException("Compétition non trouvée"));

        equipe.getCompetitions().add(competition);
//        competition.getTeams().add(equipe);

        teamRepository.save(equipe);
        competitionRepository.save(competition);
    }


    private String generateQRCode(String data) {
        return "http://api.qrserver.com/v1/create-qr-code/?data=" + data + "&size=75x75";
    }


    @Override
    public Competition addCompetitionWithAvailabilityCheck(saveReservationDTO dto) throws Exception {
        try {
            Terrain terrain = terrainRepository.findById(dto.terrain()).get();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//            Date dateDebut = dateFormat.parse(dto.date_debut());
//
//            Date dateFin = dateFormat.parse(dto.date_fin());
//
//            LocalDateTime localDateTimeDeb = dateDebut.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//            LocalDateTime localDateTimeFin = dateFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();


            String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX"; // Adjust the pattern to include milliseconds and timezone
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

// Set the timezone of the date format to UTC
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

// Parse the date strings
            Date dateDebut = dateFormat.parse(dto.date_debut());
            Date dateFin = dateFormat.parse(dto.date_fin());

// Convert Date to LocalDateTime
            LocalDateTime localDateTimeDeb = dateDebut.toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime();
            LocalDateTime localDateTimeFin = dateFin.toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime();
            Competition com =  new Competition();
            com.setNom(dto.nom());
            com.setCategorie(dto.categorie());
            com.setDateDebut(localDateTimeDeb);
            boolean availableToReserve = reservationTRepository.isTerrainReservedExcludingDates(terrain, localDateTimeDeb, localDateTimeFin);
            if (!availableToReserve) {
                ReservationT reservationT = ReservationT.builder()
                        .date_debut(localDateTimeDeb)
                        .date_fin(localDateTimeFin)
                        .terrain(terrain)
                        .etat(Etat.RESERVED)
                        .nbre(1)
                        .build();
                ReservationT reservation = reservationTRepository.save(reservationT);
                List<ReservationT> res = new ArrayList<>();
                res.add(reservation);
                com.setReservationTS(res);
                return competitionRepository.save(com);
            }
            throw new Exception("Le terrain et/ou date et reservée");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e);
        }
    }

}



