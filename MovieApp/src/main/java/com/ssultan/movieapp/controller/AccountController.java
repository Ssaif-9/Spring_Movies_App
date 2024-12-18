package com.ssultan.movieapp.controller;

import com.ssultan.movieapp.model.requests.LoginRequest;
import com.ssultan.movieapp.model.requests.SigninRequest;
import com.ssultan.movieapp.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200", "*"}) //important
@RestController
@RequestMapping("/api/v1/auth")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginAccount(@RequestBody LoginRequest loginRequest) {

        Map<String, String>  loginResponse = accountService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signinAccount(@RequestBody SigninRequest signinRequest) {

        accountService.addAccount(signinRequest);
        return ResponseEntity.ok().build();
    }

}

