package com.example.market.Service.JWT;

import com.example.market.Config.JwtService;
import com.example.market.DTO.JWT.AuthenticationRequest;
import com.example.market.DTO.JWT.AuthenticationResponse;
import com.example.market.Entity.Enum.Login;
import com.example.market.Repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final StaffRepo staffRepo;
    private final JwtService jwtService;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager, StaffRepo staffRepo, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.staffRepo = staffRepo;
        this.jwtService = jwtService;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var staff = staffRepo.findByEmail(authenticationRequest.getEmail()).orElseThrow(()
                -> new RuntimeException("Staff not found"));
        var userDetails = new Login(staff);
        var jwtToken = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


}
