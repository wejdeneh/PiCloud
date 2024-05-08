package com.esprit.edusched.controllers;


import com.esprit.edusched.dto.saveReservationDTO;
import com.esprit.edusched.entities.Competition;
import com.esprit.edusched.entities.ReservationT;
import com.esprit.edusched.entities.Terrain;
import com.esprit.edusched.repositories.CompetitionRepository;
import com.esprit.edusched.services.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowCredentials = "true")
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;


    @PostMapping("/addCompetition")
    public Competition addCompetition(@RequestBody Competition competition) {
        return competitionService.addCompetition(competition);
    }

    @GetMapping("/getCompetitionId/{id}")
    public Competition getCompetitionById(@PathVariable Long id) {
        return competitionService.fingById(id);
    }

    @GetMapping("/getAllCompetition")
    public List<Competition> getAllCompetition() {
        return competitionService.findAll();
    }

    @PutMapping("/update")
    public Competition updateCompetition(@RequestBody Competition competition) {
        return competitionService.updateCompetition(competition);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCompetition(@PathVariable Long id) {
        Competition competitionId = this.competitionService.fingById(id);
        this.competitionService.deleteCompetition(competitionId);
    }

    @PostMapping("/affecter-equipe/{idCompetition}/{idTeam}")
    public ResponseEntity<String> affecterEquipeACompetition(@PathVariable long idCompetition, @PathVariable long idTeam) {
        competitionService.affecterCompetitionAEquipe(idCompetition, idTeam);
        return ResponseEntity.ok("Compétition affectée à l'équipe avec succès.");
    }

    //    @PostMapping("/addWithAvailabilityCheck")
//    public ResponseEntity<String> addCompetitionWithAvailabilityCheck(@RequestBody Competition Competition) {
//        try {
//            Terrain terrain = Competition.getTerrain();
//            Competition competition = Competition.getCompetition();
//            ReservationT reservation = Competition.getReservation();
//
//            competitionService.addCompetitionWithAvailabilityCheck(terrain, competition, reservation);
//
//            return ResponseEntity.ok("Compétition ajoutée avec succès.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout de la compétition : " + e.getMessage());
//        }
//    }
    @PostMapping("/addWithAvailabilityCheck")
    public ResponseEntity<?> addCompetitionWithAvailabilityCheck(@RequestBody saveReservationDTO requestBody) {

        try {

            Competition com = competitionService.addCompetitionWithAvailabilityCheck(requestBody);
                return ResponseEntity.ok(com);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout de la compétition : " + e.getMessage());
        }
    }


}
