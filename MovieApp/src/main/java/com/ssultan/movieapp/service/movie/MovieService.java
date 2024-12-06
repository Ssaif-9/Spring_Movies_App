package com.ssultan.movieapp.service.movie;

import com.ssultan.movieapp.entity.Movie;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {
    Movie searchMovieByImdbId(String movieImdbId);
    Movie searchMovieByTitleAndYear(String movieTitle, String movieYear);

    void saveMovie(Movie movie);

    void deleteMovie(Movie movie);
}
