package com.example.practicapc1.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequestDto {
    @NotBlank(message = "El email es obligatorio")
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank
    @Min(8) @NotNull
    @Column(nullable = false)
    @NotBlank(message = "El email es obligatorio")
    private String password;
}
