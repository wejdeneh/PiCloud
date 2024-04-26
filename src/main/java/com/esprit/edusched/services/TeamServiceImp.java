package com.esprit.edusched.services;


import com.esprit.edusched.entities.Team;
import com.esprit.edusched.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImp implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public void deleteTeam(Team team) {
        teamRepository.delete(team);
    }

    @Override
    public Team fingById(Long id) {
        if (id != null) {
            final Optional<Team> optionalTeam = teamRepository.findById(id);
            if (optionalTeam.isPresent()) {
                return optionalTeam.get();
            }
        }
        return null;
    }
}
