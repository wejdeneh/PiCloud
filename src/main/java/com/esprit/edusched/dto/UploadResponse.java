package com.esprit.edusched.dto;

import com.esprit.edusched.enums.EnumClasse;
import com.esprit.edusched.enums.EnumSpecialite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadResponse {
    String name;
    String email;
    byte[] image;
    private EnumClasse enumClasse;
    private EnumSpecialite enumSpecialite;
    private String number;
    private String nationality;
    private Date creationDate;
}
