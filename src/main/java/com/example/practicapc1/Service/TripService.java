package com.example.practicapc1.Service;

import com.example.practicapc1.Dto.TripRequestDto;
import com.example.practicapc1.Dto.TripResponseDto;
import com.example.practicapc1.Model.Trip;
import com.example.practicapc1.Model.User;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class TripService {
    private final TripService tripRepository;
    private final ModelMapper modelMapper;
    private final RouteService routeRepository;

    public TripService(TripService tripRepository, ModelMapper modelMapper, RouteService routeRepository) {
        this.tripRepository = tripRepository;
        this.modelMapper = modelMapper;
        this.routeRepository = routeRepository;
    }
    //metodo post
    public TripResponseDto create (TripRequestDto dto, User user){
        Trip trip = modelMapper.map(dto, Trip.class);
        trip.setAvailableSeats(dto.getTotalSets());
        trip.setStatus("SCHEDULED");
        Trip saved = tripRepository.save(trip);
        return ModelMapper.map(saved, TripResponseDto.class);
    }



}
