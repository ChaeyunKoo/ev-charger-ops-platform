package com.example.backend.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginReq {

    private String employeeNum;
    private String password;
}
