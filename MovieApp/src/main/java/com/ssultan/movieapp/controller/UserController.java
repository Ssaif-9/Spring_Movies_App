package com.ssultan.movieapp.controller;


import com.ssultan.movieapp.model.response.PageResponse;
import com.ssultan.movieapp.model.dtos.MovieDto;
import com.ssultan.movieapp.model.omdbmodel.MovieFullInfo;
import com.ssultan.movieapp.service.movie.MovieService;
import com.ssultan.movieapp.service.rating.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "*"}) //important
@RestController
@RequestMapping("/api/v1/home")
public class UserController {

    private final MovieService movieService;

    private final RatingService ratingService;

    @Autowired
    public UserController(MovieService movieService, RatingService ratingService) {
        this.movieService = movieService;
        this.ratingService = ratingService;
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

    @GetMapping("rate/{username}/{imdbId}")
    public  ResponseEntity<?> getMovieRate(@PathVariable String username, @PathVariable String imdbId){
        Integer rate = ratingService.getRating(username,imdbId);
        return ResponseEntity.ok(rate);
    }

    @GetMapping("rate/{username}/{imdbId}/{rating}")
    public ResponseEntity<?> rateMovie(@PathVariable String username ,@PathVariable String imdbId,@PathVariable Integer rating){
        ratingService.rateMovie(username,imdbId,rating);
        return ResponseEntity.ok().build();
    }
}
