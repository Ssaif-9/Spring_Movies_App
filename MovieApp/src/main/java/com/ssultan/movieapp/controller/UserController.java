package com.ssultan.movieapp.controller;


import com.ssultan.movieapp.model.PageResponse;
import com.ssultan.movieapp.model.dtos.MovieDto;
import com.ssultan.movieapp.model.omdbmodel.MovieFullInfo;
import com.ssultan.movieapp.service.movie.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "*"}) //important
@RestController
@RequestMapping("/api/v1/home")
public class UserController {

    private final MovieService movieService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(MovieService movieService, ModelMapper modelMapper) {
        this.movieService = movieService;
        this.modelMapper = modelMapper;
    }

    @GetMapping ("/all")
    public ResponseEntity<?> getAllMovies() {
       List<MovieDto> movieDtoList= movieService.getAllMovies();
        System.out.println(movieDtoList.toString());
        return ResponseEntity.ok(movieDtoList);
    }

    @GetMapping ("/page/{page}")
    public ResponseEntity<?> pageAllMovies(@PathVariable Integer page) {
       PageResponse<MovieDto> movieDtoList= movieService.pageAllMovies(page - 1,5);
        System.out.println(movieDtoList.toString());
        return ResponseEntity.ok(movieDtoList);
    }

    @GetMapping("search/byTitle/{title}")
    public ResponseEntity<?> searchMovieBtTitle(@PathVariable String title) {
        List<MovieDto> movieDtoList= movieService.getMovieByTitle(title);
        System.out.println(movieDtoList.toString());
        return ResponseEntity.ok(movieDtoList);
    }

    @GetMapping("search/byImdbId/{imdbId}")
    public ResponseEntity<?> searchMovieBtImdbId(@PathVariable String imdbId) {
        List<MovieDto> movieDtoList= movieService.getMovieByImdbId(imdbId);
        System.out.println(movieDtoList.toString());
        return ResponseEntity.ok(movieDtoList);
    }

    @GetMapping("search/byYear/{year}")
    public ResponseEntity<?> searchMovieBtYear(@PathVariable String year) {
        List<MovieDto> movieDtoList= movieService.getMovieByYear(year);
        System.out.println(movieDtoList.toString());
        return ResponseEntity.ok(movieDtoList);
    }

    @GetMapping("/gat/allInfo/{imdbId}")
    public ResponseEntity<?> getFullInfoMovie(@PathVariable String imdbId) {
       MovieFullInfo movieDtoList= movieService.getMovieFullInfo(imdbId);
        System.out.println(movieDtoList.toString());
        return ResponseEntity.ok(movieDtoList);
    }
}
