package com.ssultan.movieapp.service.movie;

import com.ssultan.movieapp.entity.Movie;
import com.ssultan.movieapp.model.omdbmodel.MovieFullInfo;
import com.ssultan.movieapp.model.dtos.MovieDto;
import com.ssultan.movieapp.model.requests.MovieOmdbRequest;
import com.ssultan.movieapp.model.PageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    //For Admin
    MovieDto saveMovieByImdbId(MovieOmdbRequest movie);
    MovieDto saveMovieByImdbTitleAndYear(MovieOmdbRequest movie);

    List<MovieDto> saveBatchMoviesByImdbId(List<MovieOmdbRequest> movies);
    List<MovieDto> saveBatchMovieByImdbTitleAndYear(List<MovieOmdbRequest> movies);

    void deleteMovie(Long movieId);

    void deleteMovieByImdbId(String imdbId);
    void deleteBatchMoviesByImdbId(List<String> imdbIds);

    //For User
    List<MovieDto> getAllMovies();
    MovieFullInfo getMovieById(Long movieId);

    MovieFullInfo getMovieByTitle(String movieTitle);
    MovieFullInfo getMovieByImdbId(String movieImdbId);
    List<MovieDto> getMovieByYear(String movieYear);

    PageResponse<Movie> getAllMovies(Integer pageNumber, Integer pageSize) ;


}



