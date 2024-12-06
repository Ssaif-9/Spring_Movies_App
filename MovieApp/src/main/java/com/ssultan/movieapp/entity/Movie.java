package com.ssultan.movieapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    @Column(name = "movie_title")
    private String title;

    @Column(name = "movie_type")
    private String type;

    @Column(name = "movie_imdb_id")
    private String imdbId;

    @Column(name = "movie_year")
    private String year;

    @Column(name = "movie_poster_url")
    private String posterUrl;

    public Movie() {}

    public Movie(Long id, String title, String plot, String imdbId, String year, String posterUrl) {
        this.id = id;
        this.title = title;
        this.type = plot;
        this.imdbId = imdbId;
        this.year = year;
        this.posterUrl = posterUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return type;
    }

    public void setPlot(String plot) {
        this.type = plot;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
