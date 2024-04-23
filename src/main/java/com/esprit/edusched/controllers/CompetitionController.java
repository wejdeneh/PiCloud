package com.esprit.edusched.controllers;


import com.esprit.edusched.entities.Competition;
import com.esprit.edusched.services.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowCredentials="true")
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService ;


    @PostMapping("/addCompetition")
    public Competition addCompetition(@RequestBody Competition competition){
        return competitionService.addCompetition(competition);
    }

    @GetMapping("/getCompetitionId/{id}")
    public Competition getCompetitionById(@PathVariable Long id){
        return competitionService.fingById(id);
    }

    @GetMapping("/getAllCompetition")
    public List<Competition> getAllCompetition(){
        return competitionService.findAll();
    }

    @PutMapping("/update")
    public Competition updateCompetition(@RequestBody Competition competition ){
        return competitionService.updateCompetition(competition);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCompetition(@PathVariable Long id){
        Competition competitionId=this.competitionService.fingById(id);
         this.competitionService.deleteCompetition(competitionId);
    }
    @PostMapping("/affecter-equipe/{idCompetition}/{idTeam}")
    public ResponseEntity<String> affecterEquipeACompetition(@PathVariable long idCompetition, @PathVariable long idTeam) {
        competitionService.affecterCompetitionAEquipe(idCompetition, idTeam);
        return ResponseEntity.ok("Compétition affectée à l'équipe avec succès.");
    }


}
