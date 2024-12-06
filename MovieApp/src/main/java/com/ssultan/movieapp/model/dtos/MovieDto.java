package com.ssultan.movieapp.model.dtos;

import jakarta.persistence.Column;

public class MovieDto {
    private String title;
    private String type;
    private String imdbId;
    private String year;
    private String poster;

    public MovieDto(){

    }

    public MovieDto(String title, String type, String imdbId, String year, String poster) {
        this.title = title;
        this.type = type;
        this.imdbId = imdbId;
        this.year = year;
        this.poster = poster;
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

    @Override
    public String toString() {
        return "MovieDto{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", imdbId='" + imdbId + '\'' +
                ", year='" + year + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
