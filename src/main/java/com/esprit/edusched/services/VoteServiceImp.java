package com.esprit.edusched.services;

import com.esprit.edusched.entities.Competition;
import com.esprit.edusched.entities.Team;
import com.esprit.edusched.entities.User;
import com.esprit.edusched.entities.Vote;
import com.esprit.edusched.repositories.CompetitionRepository;
import com.esprit.edusched.repositories.TeamRepository;
import com.esprit.edusched.repositories.UserRepository;
import com.esprit.edusched.repositories.VoteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteServiceImp implements VoteService {
    @Autowired
    private VoteRepository voteRepository ;
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private CompetitionRepository competitionRepository ;
    @Autowired
    private TeamRepository teamRepository ;


    @Override
    public Vote addVote(Vote vote) {

        return voteRepository.save(vote);
    }

    @Override
    public Vote updateVote(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public List<Vote> findAll() {
        return voteRepository.findAll();
    }

    @Override
    public void deleteVote(Vote vote) {
        voteRepository.delete(vote);

    }

    @Override
    public Vote fingById(Long id) {
        if (id != null) {
            final Optional<Vote> optionalVote = voteRepository.findById(id);
            if (optionalVote.isPresent()) {
                return optionalVote.get();
            }
        }
        return null;
    }

    @Override
    public Vote createVote(Vote v, long idTeam, long idCompetition, long idUser) {
        System.out.println("helloooooooooooooooooooooooooooooo");
        Team team = teamRepository.findById(idTeam).orElseThrow(() -> new EntityNotFoundException("Team not found"));
        Competition competition = competitionRepository.findById(idCompetition).orElseThrow(() -> new EntityNotFoundException("Competition not found"));
        User user = userRepository.findById(idUser).orElseThrow(() -> new EntityNotFoundException("User not found"));
        v.setTeam(team);
        v.setCompetition(competition);
        v.setUser(user);
        return voteRepository.save(v);
    }
}
