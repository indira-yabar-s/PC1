package com.example.practicapc1.Dto;

import lombok.Data;

@Data
public class TripResponseDto {
    private Long id;
    private String origin;
    private Integer availableSeats;
    private String status;

}
