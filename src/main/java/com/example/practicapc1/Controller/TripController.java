package com.example.practicapc1.Controller;

import com.example.practicapc1.Dto.TripResponseDto;
import com.example.practicapc1.Model.User;
import com.example.practicapc1.Service.TripService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RequestMapping("/trips")
public class TripController {
    private final TripService tripService;
    public TripController(TripService tripService){
        this.tripService= tripService;
    }

    @PostMapping
    public ResponseEntity<TripResponseDto> create (
            @Valid @AuthenticationPrincipal User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(tripService.create(())):
    }

}

