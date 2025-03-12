package com.MathView.user_api_v1.controller;

import com.MathView.user_api_v1.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return authService.authenticate(username, password) ? "Login exitoso" : "Credenciales incorrectas";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        authService.register(username, password);
        return "Usuario registrado con éxito";
    }
}

