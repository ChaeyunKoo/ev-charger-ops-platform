package com.example.backend.user.dto;

import com.example.backend.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupReq {

    private String employeeNum;
    private String password;
    private String username;
    private String department;

    public User toEntity(String encodedPassword) {
        return User.builder()
                .employeeNum(this.employeeNum)
                .password(encodedPassword)
                .username(this.username)
                .department(this.department)
                .build();
    }
}
