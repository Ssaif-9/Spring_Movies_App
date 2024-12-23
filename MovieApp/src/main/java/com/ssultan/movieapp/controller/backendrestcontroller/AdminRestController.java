package com.ssultan.movieapp.controller.backendrestcontroller;

import com.ssultan.movieapp.exception.ErrorException;
import com.ssultan.movieapp.exception.NotFoundMovieException;
import com.ssultan.movieapp.model.dtos.MovieDto;
import com.ssultan.movieapp.model.requests.MovieOmdbRequest;
import com.ssultan.movieapp.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminRestController {

    private MovieService movieService;
    @Autowired
    public AdminRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/addById")
    public MovieDto addMovieById(@RequestBody String movieImdbId) {
        return movieService.saveMovieByImdbId(movieImdbId);
    }

    @PostMapping("/addByTitle")
    public MovieDto addMovieByTitle(@RequestBody MovieOmdbRequest movieOmdbRequest) {
        return movieService.saveMovieByImdbTitleAndYear(movieOmdbRequest);
    }

    @PostMapping("/addBatchById")
    public List<MovieDto> addBatchMovieById(@RequestBody List<String> movieOmdbRequests) {
        return movieService.saveBatchMoviesByImdbId(movieOmdbRequests);
    }

    @PostMapping("/addBatchByTitle")
    public List<MovieDto> addBatchMovieByTitleAndYear(@RequestBody List<MovieOmdbRequest> movieOmdbRequests) {
        return movieService.saveBatchMovieByImdbTitleAndYear(movieOmdbRequests);
    }

    @DeleteMapping("/deleteById/{movieId}")
    public void deleteMovieById(@PathVariable Long movieId) {
        movieService.deleteMovie(movieId);
    }

    @DeleteMapping("/deleteByImdbId/{imdbId}")
    public void deleteMovieById(@PathVariable String imdbId) {
        movieService.deleteMovieByImdbId(imdbId);
    }

    @PostMapping("/deleteBatch")
    public void deleteBatchMovieByImdbId(@RequestBody List<String> movieIds) {
        movieService.deleteBatchMoviesByImdbId(movieIds);
    }

    @ExceptionHandler(value = NotFoundMovieException.class)
    ErrorException getInvalidAccountDataException(NotFoundMovieException notFoundMovieException) {
        return new ErrorException(notFoundMovieException.getExceptionMessage());
    }


}
