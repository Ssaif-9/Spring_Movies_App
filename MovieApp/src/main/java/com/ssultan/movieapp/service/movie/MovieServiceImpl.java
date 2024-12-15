package com.ssultan.movieapp.service.movie;

import com.ssultan.movieapp.entity.Movie;
import com.ssultan.movieapp.entity.Rating;
import com.ssultan.movieapp.exception.AlreadyExistMovieException;
import com.ssultan.movieapp.exception.NotFoundMovieException;
import com.ssultan.movieapp.model.omdbmodel.MovieFullInfo;
import com.ssultan.movieapp.model.dtos.MovieDto;
import com.ssultan.movieapp.model.requests.MovieOmdbRequest;
import com.ssultan.movieapp.reposatiry.MovieRepo;
import com.ssultan.movieapp.reposatiry.RatingRepo;
import com.ssultan.movieapp.utils.MovieUtil;
import com.ssultan.movieapp.model.response.PageResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepo movieRepo;
    private final RatingRepo ratingRepo;
    private final ModelMapper modelMapper;



    @Autowired
    public MovieServiceImpl(MovieRepo movieRepo, ModelMapper modelMapper, RatingRepo ratingRepo) {
        this.movieRepo = movieRepo;
        this.modelMapper = modelMapper;
        this.ratingRepo = ratingRepo;
    }


    @Override
    public MovieDto saveMovieByImdbId(String imdbId) {
        if (movieRepo.existsByImdbId(imdbId)) {
            throw new AlreadyExistMovieException("already Exist");
        }
        MovieFullInfo movieFullInfo  = MovieUtil.getAllMovieDetailsByImdbId(imdbId);
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
    public List<MovieDto> saveBatchMoviesByImdbId(List<String> movies) {
        List<MovieDto> movieDtoList = new ArrayList<>();
        for(String movie : movies){
            if (movieRepo.existsByImdbId(movie)) {
               continue;
            }
            MovieFullInfo movieFullInfo  = MovieUtil.getAllMovieDetailsByImdbId(movie);
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
    public MovieDto deleteMovieByImdbId(String imdbId) {

        // Check if the movie exists
        Movie movie = movieRepo.findByImdbId(imdbId);
        if (movie == null) {
            throw new NotFoundMovieException("No movie found to delete");
        }

        // Check if the movie has a rating
        List<Rating> ratingList = ratingRepo.findByMovieId(movie.getId());
        if (ratingList != null && !ratingList.isEmpty()) {
            ratingRepo.deleteAll(ratingList);
        }
        movieRepo.deleteById(movie.getId());

        return modelMapper.map(movie, MovieDto.class);
    }

    @Override
    public void deleteBatchMoviesByImdbId(List<String> imdbIds) {
        for (String imdbId : imdbIds) {
            if (!movieRepo.existsByImdbId(imdbId)) {
                throw new NotFoundMovieException("NO Movie To Delete");
            }
            deleteMovieByImdbId(imdbId);
        }
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
    public List<MovieDto> getMovieByTitle(String movieTitle) {
        if (!movieRepo.existsByTitle(movieTitle)) {
            return new ArrayList<MovieDto>();
            //throw new NotFoundMovieException("not found");
        }
        Movie movie = movieRepo.findByTitle(movieTitle);
        MovieFullInfo movieFullInfo=MovieUtil.getAllMovieDetailsByTitleAndYear(movie.getTitle(),movie.getYear());
        MovieDto movieDto=modelMapper.map(movieFullInfo,MovieDto.class);
        List<MovieDto> movieDtoList=new ArrayList<>();
        movieDtoList.add(movieDto);

        return movieDtoList ;
    }

    @Override
    public List<MovieDto> getMovieByImdbId(String movieImdbId) {
        if (!movieRepo.existsByImdbId(movieImdbId)) {
            return new ArrayList<MovieDto>();
            //throw new NotFoundMovieException("not found");
        }
        Movie movie = movieRepo.findByImdbId(movieImdbId);
        MovieFullInfo movieFullInfo=MovieUtil.getAllMovieDetailsByImdbId(movie.getImdbId());
        MovieDto movieDto=modelMapper.map(movieFullInfo,MovieDto.class);
        List<MovieDto> movieDtoList=new ArrayList<>();
        movieDtoList.add(movieDto);
        return movieDtoList;
    }

    @Override
    public List<MovieDto> getMovieByYear(String movieYear) {
        if (!movieRepo.existsByYear(movieYear)) {
            return new ArrayList<MovieDto>();
            //throw new NotFoundMovieException("not found");
        }
        List<Movie> movies = movieRepo.findByYear(movieYear);
        return movies.stream().map(movie ->modelMapper.map(movie,MovieDto.class)).collect(Collectors.toList());
    }

    public PageResponse<MovieDto> pageAllMovies(Integer pageNumber, Integer pageSize)  {

        Pageable paging;
        paging = PageRequest.of(pageNumber, pageSize);

        Page<MovieDto> pagedResult = movieRepo.findAll(paging)
                .map(movie -> modelMapper.map(movie,MovieDto.class));

        if (pagedResult.hasContent()) {
            PageResponse<MovieDto> moviePage = new PageResponse<>();
            moviePage.setTotalPages(pagedResult.getTotalPages());
            moviePage.setTotalElements(pagedResult.getTotalElements());
            moviePage.setEntity(pagedResult.getContent());

            return moviePage;
        } else {
            throw new NotFoundMovieException("There's no movie in database or Invalid paging" );
        }
    }

    @Override
    public MovieFullInfo getMovieFullInfo(String imdbId) {
        if(!movieRepo.existsByImdbId(imdbId)){
            throw new NotFoundMovieException("not found");
        }
        Movie movie = movieRepo.findByImdbId(imdbId);
        return MovieUtil.getAllMovieDetailsByImdbId(movie.getImdbId());

    }

}
