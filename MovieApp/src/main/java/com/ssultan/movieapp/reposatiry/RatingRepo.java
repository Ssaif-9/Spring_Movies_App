package com.ssultan.movieapp.reposatiry;

import com.ssultan.movieapp.entity.Account;
import com.ssultan.movieapp.entity.Movie;
import com.ssultan.movieapp.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Long> {

    Optional<Rating> findByAccountAndMovie(Account user, Movie movie);
    List<Rating> findByMovieId(Long id);

}
