package com.ssultan.movieapp.service.movie;

import com.ssultan.movieapp.entity.Movie;
import com.ssultan.movieapp.model.MovieFullInfo;
import com.ssultan.movieapp.model.dtos.MovieDto;
import com.ssultan.movieapp.model.requests.MovieOmdbRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    //For Admin
    MovieDto saveMovieByImdbId(MovieOmdbRequest movie);
    MovieDto saveMovieByImdbTitleAndYear(MovieOmdbRequest movie);
    void deleteMovie(Long movieId);

    //For User
    List<MovieDto> getAllMovies();
    MovieFullInfo getMovieById(Long movieId);

    MovieFullInfo getMovieByTitle(String movieTitle);
    MovieFullInfo getMovieByImdbId(String movieImdbId);
    List<MovieDto> getMovieByYear(String movieYear);



}
