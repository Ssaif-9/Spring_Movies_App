package com.ssultan.movieapp.controller;

import com.ssultan.movieapp.model.dtos.MovieDto;
import com.ssultan.movieapp.model.requests.MovieOmdbRequest;
import com.ssultan.movieapp.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "*"}) //important
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final MovieService movieService;

    @Autowired
    public AdminController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllMovies() {
       List<MovieDto> response=  movieService.getAllMovies();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add/imdbId")
    public ResponseEntity<?> addMovieByImdbId(@RequestBody String imdbId) {
       MovieDto movieDto= movieService.saveMovieByImdbId(imdbId);
       return ResponseEntity.ok(movieDto);
    }

    @PostMapping("/add/title")
    public ResponseEntity<?> addMovieByTitle(@RequestBody MovieOmdbRequest imdbId) {
        System.out.println(imdbId);
        MovieDto movieDto= movieService.saveMovieByImdbTitleAndYear(imdbId);
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping("/delete/imdbId")
    public ResponseEntity<?> deleteMovieByImdbId(@RequestBody String imdbId) {
        System.out.println(imdbId);
        MovieDto movieDto= movieService.deleteMovieByImdbId(imdbId);
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping("/addList/imdbId")
    public ResponseEntity<?> addMovieByImdbId(@RequestBody List<String> imdbId) {
        List<MovieDto> movieDto= movieService.saveBatchMoviesByImdbId(imdbId);
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping("/deleteList/imdbId")
    public ResponseEntity<?> deleteMovieByImdbId(@RequestBody List<String> imdbId) {
        movieService.deleteBatchMoviesByImdbId(imdbId);
        return ResponseEntity.ok(imdbId);
    }





}
