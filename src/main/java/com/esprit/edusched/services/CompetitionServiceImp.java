package com.esprit.edusched.services;


import com.esprit.edusched.entities.Competition;
import com.esprit.edusched.entities.Team;
import com.esprit.edusched.repositories.CompetitionRepository;
import com.esprit.edusched.repositories.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompetitionServiceImp implements CompetitionService{
    @Autowired
    private CompetitionRepository competitionRepository ;
    @Autowired
    private TeamRepository teamRepository;



    @Override
    public Competition addCompetition(Competition competition) {
        String qrData = "Competition Details:" + competition.getCompetitionId() + " ,Nom:" + competition.getNom() + " ,Date :" + competition.getDateDebut() + " ,Catégorie :" + competition.getCategorie();
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
        if(id!=null){
            final Optional<Competition> optionalCompetition=competitionRepository.findById(id);
            if (optionalCompetition.isPresent()){
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
        competition.getTeams().add(equipe);

        teamRepository.save(equipe);
        competitionRepository.save(competition);
    }
    private String generateQRCode(String data) {
        return "http://api.qrserver.com/v1/create-qr-code/?data=" + data + "&size=75x75";
    }


}
