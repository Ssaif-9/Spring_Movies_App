package com.ssultan.movieapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dashboard")
public class AdminController {

    @GetMapping
    public String index() {
        return "Hello ADMIN";
    }
}
