package com.ssultan.movieapp.service.movie;

import com.ssultan.movieapp.model.omdbmodel.MovieFullInfo;
import com.ssultan.movieapp.model.dtos.MovieDto;
import com.ssultan.movieapp.model.requests.MovieOmdbRequest;
import com.ssultan.movieapp.model.response.PageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    //For Admin
    MovieDto saveMovieByImdbId(String movieImdbId);
    MovieDto saveMovieByImdbTitleAndYear(MovieOmdbRequest movie);

    List<MovieDto> saveBatchMoviesByImdbId(List<String> movies);
    List<MovieDto> saveBatchMovieByImdbTitleAndYear(List<MovieOmdbRequest> movies);

    void deleteMovie(Long movieId); //not important

    MovieDto deleteMovieByImdbId(String imdbId);
    void deleteBatchMoviesByImdbId(List<String> imdbIds);

    //For User
    List<MovieDto> getAllMovies();
    MovieFullInfo getMovieById(Long movieId); //not important

    List<MovieDto> getMovieByTitle(String movieTitle);
    List<MovieDto> getMovieByImdbId(String movieImdbId);
    List<MovieDto> getMovieByYear(String movieYear);

    PageResponse<MovieDto> pageAllMovies(Integer pageNumber, Integer pageSize) ;

    MovieFullInfo getMovieFullInfo(String imdbId);
}



