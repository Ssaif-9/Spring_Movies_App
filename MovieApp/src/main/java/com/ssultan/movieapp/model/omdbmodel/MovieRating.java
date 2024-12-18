package com.ssultan.movieapp.model.omdbmodel;

import com.google.gson.annotations.SerializedName;

public class MovieRating {
    @SerializedName("Source")
    private String source;
    @SerializedName("Value")
    private String value;

    public MovieRating(String source, String value) {
        this.source = source;
        this.value = value;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MovieRating{" +
                "source='" + source + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
