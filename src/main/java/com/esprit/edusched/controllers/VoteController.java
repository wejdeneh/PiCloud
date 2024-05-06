package com.esprit.edusched.controllers;


import com.esprit.edusched.entities.Vote;
import com.esprit.edusched.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowCredentials="true")
public class VoteController {
    @Autowired
    private VoteService voteService ;


    @PostMapping("/addVote")
    public Vote addVote(@RequestBody Vote vote) {
        return voteService.addVote(vote);
    }

    @GetMapping("/getVoteById/{id}")
    public Vote getVoteById(@PathVariable Long id) {
        return voteService.fingById(id);
    }

    @GetMapping("/getAllVotes")
    public List<Vote> getAllVotes() {
        return voteService.findAll();
    }

    @PutMapping("/updateVote")
    public Vote updateVote(@RequestBody Vote vote) {
        return voteService.updateVote(vote);
    }

    @DeleteMapping("/deleteVote/{id}")
    public void deleteVote(@PathVariable Long id) {
        Vote vote = voteService.fingById(id);
        voteService.deleteVote(vote);
    }
    @PostMapping("/createVote/{teamId}/{competitionId}/{userId}")
    public Vote createVote(@PathVariable("teamId") long teamId, @PathVariable("competitionId") long competitionId, @PathVariable("userId") long userId, @RequestBody Vote vote) {
        return voteService.createVote(vote, teamId, competitionId, userId);
    }

}
