package com.ssultan.movieapp.entity;

import com.ssultan.movieapp.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @NotNull
    @Column(name = "account_username")
    private String username;

    @NotNull
    @Column(name = "account_password")
    private String password;

    @Email
    @Column(name = "account_email")
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "account_role")
    private Role role;

    public Account() {

    }

    public Account(Long id, String username, String password, String email, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @NotNull Role getRole() {
        return role;
    }

    public void setRole(@NotNull Role role) {
        this.role = role;
    }
}
