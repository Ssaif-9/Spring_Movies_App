package com.ssultan.movieapp.service.rating;

import org.springframework.stereotype.Service;

@Service
public interface RatingService {
    void rateMovie(String movieImdbId,Integer rating);
    Integer getRating(String movieImdbId);
}
