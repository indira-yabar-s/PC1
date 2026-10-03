package com.example.practicapc1.Dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TripRequestDto {
    private String origin;

    private String destination;
    @NotNull @Future
    private ZonedDateTime departureTime;
    @Min(1) @Max(6)
    private Integer capacity;

    public Integer getTotalSets() {
    }
}
