package com.example.auth.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupRequest {
    private String name;
    private String number;
    private String email;
    private String password;
    private String role;
}
