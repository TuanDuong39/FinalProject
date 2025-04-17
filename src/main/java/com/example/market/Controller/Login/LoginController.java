//package com.example.market.Controller.Login;
//
//import com.example.market.DTO.JWT.AuthenticationRequest;
//import com.example.market.DTO.JWT.AuthenticationResponse;
//import com.example.market.Service.JWT.AuthService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class LoginController {
//
//    private final AuthService authService;
//
//    public LoginController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
//        return ResponseEntity.ok(authService.authenticate(authenticationRequest));
//    }
//}
