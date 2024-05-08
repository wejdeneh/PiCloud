package com.esprit.edusched.services;


import com.esprit.edusched.dto.saveReservationDTO;
import com.esprit.edusched.entities.Competition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompetitionService {
     Competition addCompetition(Competition competition);
     Competition updateCompetition(Competition competition);
     List<Competition> findAll();
     void deleteCompetition(Competition competition);
     Competition fingById(Long id );
     public void affecterCompetitionAEquipe(long idCompetition, long idTeam);
     Competition addCompetitionWithAvailabilityCheck(saveReservationDTO dto) throws Exception;

}
