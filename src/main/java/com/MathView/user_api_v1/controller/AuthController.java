package com.MathView.user_api_v1.controller;

import com.MathView.user_api_v1.service.AuthService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
    boolean authenticated = authService.authenticate(userDTO.getUsername(), userDTO.getPassword());

    if (authenticated) {
        return ResponseEntity.ok(Map.of("message", "Login exitoso"));
    } else {
        return ResponseEntity.status(401).body(Map.of("message", "Credenciales incorrectas"));
    }
}

@PostMapping("/register")
public String register(@RequestBody UserDTO userDTO) {
    authService.register(userDTO.getUsername(), userDTO.getPassword());
    return "Usuario registrado con éxito";
}

}

