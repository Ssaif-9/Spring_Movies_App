package com.ssultan.movieapp.controller.restcontroller;

import com.ssultan.movieapp.entity.Movie;
import com.ssultan.movieapp.exception.AlreadyExistMovieException;
import com.ssultan.movieapp.exception.ErrorException;
import com.ssultan.movieapp.exception.NotFoundMovieException;
import com.ssultan.movieapp.model.omdbmodel.MovieFullInfo;
import com.ssultan.movieapp.model.dtos.MovieDto;
import com.ssultan.movieapp.service.movie.MovieService;
import com.ssultan.movieapp.model.PageResponse;
import com.ssultan.movieapp.service.rating.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {

    private final MovieService movieService;

    private final RatingService ratingService;

    @Autowired
    public UserRestController(MovieService movieService, RatingService ratingService) {
        this.movieService = movieService;
        this.ratingService = ratingService;
    }

    @GetMapping
    public List<MovieDto> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/page/{pageNo}")
    public PageResponse<MovieDto> getAllMovies(@PathVariable Integer pageNo) {
            return movieService.pageAllMovies(pageNo - 1, 5);
    }

    @GetMapping("/{movieId}")
    public MovieFullInfo getMovieById(@PathVariable Long movieId){
        return movieService.getMovieById(movieId);
    }

    @GetMapping("/search/imdbId/{imdbId}")
    public List<MovieDto> getMovieByImdbId(@PathVariable String imdbId){
        return movieService.getMovieByImdbId(imdbId);
    }

    @GetMapping("search/title/{title}")
    public List<MovieDto> getMovieByTitle(@PathVariable String title){
        return movieService.getMovieByTitle(title);
    }

    @GetMapping("search/year/{year}")
    public List<MovieDto> getMovieByYear(@PathVariable String year){
        return movieService.getMovieByYear(year);
    }

//    @GetMapping("rate/{accountId}/{imdbId}")
//    public Integer getMovieRate(@PathVariable Long accountId, @PathVariable String imdbId){
//          return ratingService.getRating(accountId,imdbId);
//    }
//
//    @PostMapping("rate/{accountId}/{imdbId}/{rating}")
//    public void rateMovie(@PathVariable Long accountId,@PathVariable String imdbId,@PathVariable Integer rating){
//         ratingService.rateMovie(accountId,imdbId,rating);
//    }


    @ExceptionHandler(value = NotFoundMovieException.class)
    ErrorException getInvalidAccountDataException(NotFoundMovieException notFoundMovieException) {
        return new ErrorException(notFoundMovieException.getExceptionMessage());
    }

    @ExceptionHandler(value = AlreadyExistMovieException.class)
    ErrorException getAlreadyExistException(AlreadyExistMovieException alreadyExistMovieException) {
        return new ErrorException(alreadyExistMovieException.getMessageException());
    }

}
