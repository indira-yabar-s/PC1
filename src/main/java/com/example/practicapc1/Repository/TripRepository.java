package com.example.practicapc1.Repository;

import com.example.practicapc1.Model.SeatRequest;
import com.example.practicapc1.Model.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface TripRepository extends JpaRepository<Trip, Long> {
    Page<Trip> findByStatus (String status, Pageable pageable);
    Page<Trip> findByAvailableSeatsGratherThan (Integer n, Pageable pageable);
    Page<SeatRequest> findByPassergerId (Long userId, Pageable pageable);


}
