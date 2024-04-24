package com.esprit.edusched.services;


import com.esprit.edusched.entities.Vote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoteService {
    Vote addVote(Vote vote);
    Vote updateVote(Vote vote);
    List<Vote> findAll();
    void deleteVote(Vote vote);
    Vote fingById(Long id );
    //public Vote createVote(Vote v, long idTeam, long idCompetition, long idUser) ;
}
