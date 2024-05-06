package com.esprit.edusched.dto;

import com.esprit.edusched.entities.ReactType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReactDTO {
    private int offreId;
    private Long id;
    private Long userId;
    private ReactType reactType;

    // Constructors




}

