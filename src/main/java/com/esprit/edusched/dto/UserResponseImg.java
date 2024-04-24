package com.esprit.edusched.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseImg {
    private String name;
    private String email;
    private byte[] image;
}
