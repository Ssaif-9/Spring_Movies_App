package com.ssultan.movieapp.service.movie;

import com.ssultan.movieapp.entity.Movie;
import com.ssultan.movieapp.exception.AlreadyExistMovieException;
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
        if (movieRepo.existsByImdbId(movie.getImdbId())) {
            throw new AlreadyExistMovieException("already Exist");
        }
        MovieFullInfo movieFullInfo  = MovieUtil.getAllMovieDetailsByImdbId(movie.getImdbId());
        Movie Localmovie = modelMapper.map(movieFullInfo, Movie.class);
        movieRepo.save(Localmovie);
        return  modelMapper.map(movieFullInfo, MovieDto.class);
    }

    @Override
    public MovieDto saveMovieByImdbTitleAndYear(MovieOmdbRequest movie) {

        if (movieRepo.existsByTitle(movie.getTitle())) {
            throw new AlreadyExistMovieException("already Exist");
        }
        MovieFullInfo movieFullInfo  = MovieUtil.getAllMovieDetailsByTitleAndYear(movie.getTitle(),movie.getYear());
        Movie Localmovie = modelMapper.map(movieFullInfo, Movie.class);
        movieRepo.save(Localmovie);
        return  modelMapper.map(movieFullInfo, MovieDto.class);
    }

    @Override
    public List<MovieDto> saveBatchMoviesByImdbId(List<MovieOmdbRequest> movies) {
        List<MovieDto> movieDtoList = new ArrayList<>();
        for(MovieOmdbRequest movie : movies){
            if (movieRepo.existsByImdbId(movie.getImdbId())) {
               continue;
            }
            MovieFullInfo movieFullInfo  = MovieUtil.getAllMovieDetailsByImdbId(movie.getImdbId());
            Movie Localmovie = modelMapper.map(movieFullInfo, Movie.class);
            movieRepo.save(Localmovie);
            movieDtoList.add(modelMapper.map(movieFullInfo, MovieDto.class));
        }
        return movieDtoList;
    }

    @Override
    public List<MovieDto> saveBatchMovieByImdbTitleAndYear(List<MovieOmdbRequest> movies) {
        List<MovieDto> movieDtoList = new ArrayList<>();
        for(MovieOmdbRequest movie : movies){
            if (movieRepo.existsByTitle(movie.getTitle())) {
                continue;
            }
            MovieFullInfo movieFullInfo  = MovieUtil.getAllMovieDetailsByTitleAndYear(movie.getTitle(),movie.getYear());
            Movie Localmovie = modelMapper.map(movieFullInfo, Movie.class);
            movieRepo.save(Localmovie);
            movieDtoList.add(modelMapper.map(movieFullInfo, MovieDto.class));
        }
        return movieDtoList;
    }

    @Override
    public void deleteMovie(Long movieId) {
        if (!movieRepo.existsById(movieId)) {
            throw new NotFoundMovieException("NO Movie To Delete");
        }
        movieRepo.deleteById(movieId);
    }

    @Override
    public void deleteMovieByImdbId(String imdbId) {

        if (!movieRepo.existsByImdbId(imdbId)) {
            throw new NotFoundMovieException("NO Movie To Delete");
        }
        Movie movie = movieRepo.findByImdbId(imdbId);
        movieRepo.deleteById(movie.getId());
    }

    @Override
    public void deleteBatchMoviesByImdbId(List<String> imdbIds) {
        imdbIds.stream()
                .filter(movieRepo::existsByImdbId)
                .map(movieRepo::findByImdbId)
                .forEach((movie-> movieRepo.deleteById(movie.getId())));
    }

    @Override
    public List<MovieDto> getAllMovies() {
        List<Movie> movies = movieRepo.findAll();

        return movies.stream().map(movie -> modelMapper
                .map(movie,MovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovieFullInfo getMovieById(Long movieId) {
        Movie movie = movieRepo.findById(movieId).orElse(new Movie());
        if (movie.getImdbId()==null)
            throw new NotFoundMovieException("not found");
        return MovieUtil.getAllMovieDetailsByImdbId(movie.getImdbId());
    }

    @Override
    public MovieFullInfo getMovieByTitle(String movieTitle) {
        if (!movieRepo.existsByTitle(movieTitle)) {
            throw new NotFoundMovieException("not found");
        }
        Movie movie = movieRepo.findByTitle(movieTitle);
        return MovieUtil.getAllMovieDetailsByTitleAndYear(movie.getTitle(),movie.getYear());
    }

    @Override
    public MovieFullInfo getMovieByImdbId(String movieImdbId) {
        if (!movieRepo.existsByImdbId(movieImdbId)) {
            throw new NotFoundMovieException("not found");
        }
        Movie movie = movieRepo.findByImdbId(movieImdbId);
        return MovieUtil.getAllMovieDetailsByImdbId(movie.getImdbId());
    }

    @Override
    public List<MovieDto> getMovieByYear(String movieYear) {
        List<Movie> movies = movieRepo.findByYear(movieYear);
        if (movies.isEmpty()){
            throw new NotFoundMovieException("not found");
        }
        return movies.stream().map(movie ->modelMapper.map(movie,MovieDto.class)).collect(Collectors.toList());
    }

}
