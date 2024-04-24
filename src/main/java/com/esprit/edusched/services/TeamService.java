package com.esprit.edusched.services;


import com.esprit.edusched.entities.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
    Team addTeam(Team team);
    Team updateTeam(Team team);
    List<Team> findAll();
    void deleteTeam(Team Team);
    Team fingById(Long id );
}
