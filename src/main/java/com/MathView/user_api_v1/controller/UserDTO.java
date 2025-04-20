package com.MathView.user_api_v1.controller;

public class UserDTO {
    private String username;
    private String password;

    // Constructor vacío (necesario para la deserialización con @RequestBody)
    public UserDTO() {
    }

    // Constructor con parámetros
    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
