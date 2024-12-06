package com.ssultan.movieapp.controller;

import com.ssultan.movieapp.model.MovieFullInfo;
import com.ssultan.movieapp.model.dtos.MovieDto;
import com.ssultan.movieapp.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final MovieService movieService;

    @Autowired
    public UserController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDto> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{movieId}")
    public MovieFullInfo getMovieById(@PathVariable Long movieId){
        return movieService.getMovie(movieId);
    }

}
