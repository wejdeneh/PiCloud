package com.esprit.edusched.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserResponseRegister {

    private String verificationCode;
    private boolean enabled;

}
