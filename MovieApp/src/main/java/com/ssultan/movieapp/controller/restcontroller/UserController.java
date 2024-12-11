package com.ssultan.movieapp.controller.restcontroller;


import com.ssultan.movieapp.model.dtos.MovieDto;
import com.ssultan.movieapp.model.omdbmodel.MovieFullInfo;
import com.ssultan.movieapp.service.movie.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "*"}) //important
@RestController
@RequestMapping("/api/v1/home")
public class UserController {

    private final MovieService movieService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(MovieService movieService, ModelMapper modelMapper) {
        this.movieService = movieService;
        this.modelMapper = modelMapper;
    }

    @GetMapping ("/all")
    public ResponseEntity<?> getAllMovies() {
       List<MovieDto> movieDtoList= movieService.getAllMovies();
        System.out.println(movieDtoList.toString());
        return ResponseEntity.ok(movieDtoList);
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getAllMovies(@PathVariable String title) {
        MovieFullInfo movieDtoList= movieService.getMovieByTitle(title);
        MovieDto movieDto = modelMapper.map(movieDtoList, MovieDto.class);
        System.out.println(movieDto.toString());
        return ResponseEntity.ok(movieDto);
    }
}
