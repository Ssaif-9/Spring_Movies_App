package com.ssultan.movieapp.service.movie;

import com.ssultan.movieapp.entity.Movie;
import com.ssultan.movieapp.exception.NotFoundMovieException;
import com.ssultan.movieapp.model.MovieFullInfo;
import com.ssultan.movieapp.model.dtos.MovieDto;
import com.ssultan.movieapp.model.requests.MovieOmdbRequest;
import com.ssultan.movieapp.reposatiry.MovieRepo;
import com.ssultan.movieapp.utils.MovieUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepo movieRepo;
    private final ModelMapper modelMapper;



    @Autowired
    public MovieServiceImpl(MovieRepo movieRepo, ModelMapper modelMapper) {
        this.movieRepo = movieRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public MovieDto saveMovieByImdbId(MovieOmdbRequest movie) {
        MovieFullInfo movieFullInfo  = MovieUtil.getAllMovieDetailsByImdbId(movie.getImdbId(),movie.getType());
        Movie Localmovie = modelMapper.map(movieFullInfo, Movie.class);
        movieRepo.save(Localmovie);
        return  modelMapper.map(movieFullInfo, MovieDto.class);
    }

    @Override
    public MovieDto saveMovieByImdbTitleAndYear(MovieOmdbRequest movie) {
        MovieFullInfo movieFullInfo  = MovieUtil.getAllMovieDetailsByTitleAndYear(movie.getTitle(),movie.getYear(),movie.getType());
        System.out.println(movieFullInfo.toString());
        Movie Localmovie = modelMapper.map(movieFullInfo, Movie.class);
        System.out.println(Localmovie.toString());
        movieRepo.save(Localmovie);
        return  modelMapper.map(movieFullInfo, MovieDto.class);
    }

    @Override
    public void deleteMovie(Long movieId) {
        movieRepo.deleteById(movieId);
    }

    @Override
    public List<MovieDto> getAllMovies() {
        List<Movie> movies = movieRepo.findAll();

        return movies.stream().map(movie -> modelMapper
                .map(movie,MovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovieFullInfo getMovie(Long movieId) {
        Movie movie = movieRepo.findById(movieId).orElse(new Movie());
        if (movie.getImdbId()==null)
            throw new NotFoundMovieException("not found");
        return MovieUtil.getAllMovieDetailsByImdbId(movie.getImdbId(),"FULL");
    }
}
