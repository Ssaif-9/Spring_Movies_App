package com.ssultan.movieapp.service.rating;

import org.springframework.stereotype.Service;

@Service
public interface RatingService {

    void rateMovie(String userName ,String movieImdbId,Integer rating);
    Integer getRating(String userName ,String movieImdbId);
}
