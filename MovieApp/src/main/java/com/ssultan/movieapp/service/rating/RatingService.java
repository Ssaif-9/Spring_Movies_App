package com.ssultan.movieapp.service.rating;

import com.ssultan.movieapp.entity.Movie;
import com.ssultan.movieapp.entity.Rating;
import org.springframework.stereotype.Service;

@Service
public interface RatingService {
    void rateMovie(Long accountId,String movieImdbId,Integer rating);
    Integer getRating(Long accountId,String movieImdbId);
}
