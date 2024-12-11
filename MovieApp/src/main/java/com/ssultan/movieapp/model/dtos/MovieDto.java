package com.ssultan.movieapp.model.dtos;

import jakarta.persistence.Column;

public class MovieDto {
    private String title;
    private String type;
    private String imdbId;
    private String year;
    private String poster;
    private String actors;
    private String plot;
    private String imdbRating;

    public MovieDto(){

    }

    public MovieDto(String title, String type, String imdbId, String year, String poster, String actors, String plot, String imdbRating) {
        this.title = title;
        this.type = type;
        this.imdbId = imdbId;
        this.year = year;
        this.poster = poster;
        this.actors = actors;
        this.plot = plot;
        this.imdbRating = imdbRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
    public String getActors() {
        return actors;
    }
    public void setActors(String actors) {
        this.actors = actors;
    }
    public String getPlot() {
        return plot;
    }
    public void setPlot(String plot) {
        this.plot = plot;
    }
    public String getImdbRating() {
        return imdbRating;
    }
    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }


    @Override
    public String toString() {
        return "MovieDto{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", imdbId='" + imdbId + '\'' +
                ", year='" + year + '\'' +
                ", poster='" + poster + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                '}';
    }

}
