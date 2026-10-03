package com.example.practicapc1.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    @Email(message = "El formato del email es incorrecto")
    @Column(unique = true)
    private String email;

    @NotBlank
    @Min(8) @NotNull
    private String password;

}
