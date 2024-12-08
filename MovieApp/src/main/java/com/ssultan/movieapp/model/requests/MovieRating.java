package com.ssultan.movieapp.model.requests;

public class MovieRating {

    private Long UserId;
    private Long movieId;
    private Integer rating;

    public MovieRating() {}

    public MovieRating(Long userId, Long movieId, Integer rating) {
        UserId = userId;
        this.movieId = movieId;
        this.rating = rating;
    }

    public MovieRating(Long userId, Long movieId) {
        UserId = userId;
        this.movieId = movieId;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
