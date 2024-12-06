package com.ssultan.movieapp.service.movie;

import com.ssultan.movieapp.entity.Movie;
import com.ssultan.movieapp.reposatiry.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepo movieRepo;

    @Autowired
    public MovieServiceImpl(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public Movie searchMovieByImdbId(String movieImdbId) {
        return null;
    }

    @Override
    public Movie searchMovieByTitleAndYear(String movieTitle, String movieYear) {
        return null;
    }

    @Override
    public void saveMovie(Movie movie) {

    }

    @Override
    public void deleteMovie(Movie movie) {

    }
}
