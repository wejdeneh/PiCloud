package com.esprit.edusched.dto;

import com.esprit.edusched.entities.Vote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class DtoRequestVote {
    long teamId;
    long competitionId;
    long userId;
    Vote vote;
}
