package com.ssultan.movieapp.reposatiry;

import com.ssultan.movieapp.entity.Movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

    Boolean existsByTitle(String title);
    Boolean existsByImdbId(String imdbId);
    Boolean existsByYear(String movieYear);

    Movie findByTitle(String title);
    Movie findByImdbId(String imdbId);
    List<Movie> findByYear(String Year);

    Page<Movie> findAll(Pageable pageable);

}
