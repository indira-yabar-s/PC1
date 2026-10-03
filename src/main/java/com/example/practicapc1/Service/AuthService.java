package com.example.practicapc1.Service;

import com.example.practicapc1.Dto.LoginRequestDto;
import com.example.practicapc1.Dto.LoginResponseDto;
import com.example.practicapc1.Dto.UserRequestDto;
import com.example.practicapc1.Dto.UserResponseDto;
import com.example.practicapc1.Exception.UserAlreadyExistsException;
import com.example.practicapc1.Model.User;
import com.example.practicapc1.Repository.UserRepository;
import com.example.practicapc1.Security.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager, JwtService jwtService,
                       ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.modelMapper = modelMapper;
    }

    public UserResponseDto register(UserRequestDto dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new UserAlreadyExistsException("El username ya esta registrado");
        }
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new UserAlreadyExistsException("El email ya esta registrado");
        }

        User user = modelMapper.map(dto, User.class);

        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole("ROLE_USER");

        User saved = userRepository.save(user);

        return modelMapper.map(saved, UserResponseDto.class);
    }

    public LoginResponseDto login(LoginRequestDto dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

        User user = userRepository.findByUsername(dto.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);

        LoginResponseDto response = new LoginResponseDto();
        response.setToken(token);
        response.setExpiresIn(3600L);
        return response;
    }
}
