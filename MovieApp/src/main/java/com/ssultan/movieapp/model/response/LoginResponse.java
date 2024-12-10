package com.ssultan.movieapp.model.response;

public class LoginResponse {
    private String username;
    private String role;

    public LoginResponse(String username, String role) {
        this.username = username;
        this.role = role;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
