package com.esprit.edusched.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResetRequest {
    private String email;
    private String oldPassword;
    private String newPassword;

}