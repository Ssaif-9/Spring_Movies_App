package com.ssultan.movieapp.controller;

import com.ssultan.movieapp.exception.AlreadyExistMovieException;
import com.ssultan.movieapp.exception.ErrorException;
import com.ssultan.movieapp.exception.NotFoundMovieException;
import com.ssultan.movieapp.model.MovieFullInfo;
import com.ssultan.movieapp.model.dtos.MovieDto;
import com.ssultan.movieapp.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return movieService.getMovieById(movieId);
    }

    @GetMapping("/search/imdbId/{imdbId}")
    public MovieFullInfo getMovieByImdbId(@PathVariable String imdbId){
        return movieService.getMovieByImdbId(imdbId);
    }

    @GetMapping("search/title/{title}")
    public MovieFullInfo getMovieByTitle(@PathVariable String title){
        return movieService.getMovieByTitle(title);
    }

    @GetMapping("search/year/{year}")
    public List<MovieDto> getMovieByYear(@PathVariable String year){
        return movieService.getMovieByYear(year);
    }

    @ExceptionHandler(value = NotFoundMovieException.class)
    ErrorException getInvalidAccountDataException(NotFoundMovieException notFoundMovieException) {
        return new ErrorException(notFoundMovieException.getExceptionMessage());
    }

    @ExceptionHandler(value = AlreadyExistMovieException.class)
    ErrorException getAlreadyExistException(AlreadyExistMovieException alreadyExistMovieException) {
        return new ErrorException(alreadyExistMovieException.getMessageException());
    }

}
