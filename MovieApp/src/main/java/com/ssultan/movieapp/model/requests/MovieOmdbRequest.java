package com.ssultan.movieapp.model.requests;

public class MovieOmdbRequest {
    private String imdbId;
    private String title;
    private String year;
    private String type;

    public MovieOmdbRequest() {

    }
    public MovieOmdbRequest(String imdbId, String title, String year, String type) {
        this.imdbId = imdbId;
        this.title = title;
        this.year = year;
        this.type = type;
    }

    public MovieOmdbRequest(String imdbId, String type) {
        this.imdbId = imdbId;
        this.type = type;
    }

    public MovieOmdbRequest(String title, String year, String type) {
        this.title = title;
        this.year = year;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
