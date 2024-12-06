package com.ssultan.movieapp.controller;

import com.ssultan.movieapp.exception.ErrorException;
import com.ssultan.movieapp.exception.NotFoundMovieException;
import com.ssultan.movieapp.model.dtos.MovieDto;
import com.ssultan.movieapp.model.requests.MovieOmdbRequest;
import com.ssultan.movieapp.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private MovieService movieService;
    @Autowired
    public AdminController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/addById")
    public MovieDto addMovieById(@RequestBody MovieOmdbRequest movieOmdbRequest) {
        return movieService.saveMovieByImdbId(movieOmdbRequest);
    }

    @PostMapping("/addByTitle")
    public MovieDto addMovieByTitle(@RequestBody MovieOmdbRequest movieOmdbRequest) {
        return movieService.saveMovieByImdbTitleAndYear(movieOmdbRequest);
    }

    @DeleteMapping("/{movieId}")
    public void deleteMovieById(@PathVariable Long movieId) {
        movieService.deleteMovie(movieId);
    }

    @ExceptionHandler(value = NotFoundMovieException.class)
    ErrorException getInvalidAccountDataException(NotFoundMovieException notFoundMovieException) {
        return new ErrorException(notFoundMovieException.getExceptionMessage());
    }


}
