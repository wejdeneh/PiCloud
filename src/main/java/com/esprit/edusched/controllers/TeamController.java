package com.esprit.edusched.controllers;


import com.esprit.edusched.entities.Team;
import com.esprit.edusched.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowCredentials="true")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping("/addTeam")
    public Team addTeam(@RequestBody Team team) {
        return teamService.addTeam(team);
    }

    @GetMapping("/getTeamById/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamService.fingById(id);
    }

    @GetMapping("/getAllTeams")
    public List<Team> getAllTeams() {
        return teamService.findAll();
    }

    @PutMapping("/updateTeam")
    public Team updateTeam(@RequestBody Team team) {
        return teamService.updateTeam(team);
    }

    @DeleteMapping("/deleteTeam/{id}")
    public void deleteTeam(@PathVariable Long id) {
        Team team = teamService.fingById(id);
        teamService.deleteTeam(team);
    }
}
