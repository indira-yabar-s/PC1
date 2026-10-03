package com.example.practicapc1.Dto;

import lombok.Data;

@Data
public class LoginResponseDto {
    private String token;
    private Long expiresIn;
}
