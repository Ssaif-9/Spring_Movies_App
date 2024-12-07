package com.ssultan.movieapp.model.requests;

public class MovieOmdbRequest {
    private String imdbId;
    private String title;
    private String year;

    public MovieOmdbRequest() {

    }
    public MovieOmdbRequest(String imdbId, String title, String year) {
        this.imdbId = imdbId;
        this.title = title;
        this.year = year;
    }

    public MovieOmdbRequest(String imdbId) {
        this.imdbId = imdbId;
    }

    public MovieOmdbRequest(String title, String year) {
        this.title = title;
        this.year = year;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
