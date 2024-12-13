package com.ssultan.movieapp.service.rating;

import com.ssultan.movieapp.entity.Account;
import com.ssultan.movieapp.entity.Movie;
import com.ssultan.movieapp.entity.Rating;
import com.ssultan.movieapp.reposatiry.AccountRepo;
import com.ssultan.movieapp.reposatiry.MovieRepo;
import com.ssultan.movieapp.reposatiry.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingServiceImp implements RatingService {

    private final AccountRepo accountRepo;
    private final MovieRepo movieRepo;
    private final RatingRepo ratingRepo;

    @Autowired
    public RatingServiceImp(AccountRepo accountRepo,MovieRepo movieRepo,RatingRepo ratingRepo){
        this.accountRepo = accountRepo;
        this.movieRepo = movieRepo;
        this.ratingRepo = ratingRepo;
    }


    @Override
    public void rateMovie( String movieImdbId, Integer rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating must be between 0 and 10");
        }
        Account account = accountRepo.findByUsername("user");
        Movie movie = movieRepo.findByImdbId(movieImdbId);

        Rating existingRating = ratingRepo.findByAccountAndMovie(account,movie).orElse(null);

        if (existingRating != null) {
            existingRating.setRating(rating);
            ratingRepo.save(existingRating);
        } else {
            Rating newRating = new Rating();
            newRating.setAccount(account);
            newRating.setMovie(movie);
            newRating.setRating(rating);
            ratingRepo.save(newRating);
        }

    }

    @Override
    public Integer getRating(String movieImdbId) {
        Account account = accountRepo.findByUsername("user");
        Movie movie = movieRepo.findByImdbId(movieImdbId);

        Optional<Rating> rating = ratingRepo.findByAccountAndMovie(account,movie);
        if (rating.isEmpty()) {
            return 0;
        }
        return rating.get().getRating();
    }
}
