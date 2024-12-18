package com.ssultan.movieapp.utils;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.ssultan.movieapp.exception.NotFoundMovieException;
import com.ssultan.movieapp.model.omdbmodel.MovieFullInfo;
import org.springframework.web.client.RestTemplate;


public class MovieUtil {

    private static final String apiKey = "a5aa7cfa";

    public static MovieFullInfo getAllMovieDetailsByImdbId(String imdbId) throws NotFoundMovieException,JsonParseException {

        String requestUrl ="http://www.omdbapi.com/?i="+imdbId+"&apikey="+apiKey;

        RestTemplate restTemplate = new RestTemplate();
        String responseResult =restTemplate.getForObject(requestUrl,String.class);

        if (responseResult == null) {
            throw new JsonParseException("Invalid Request");
        }
        Gson jsonResponse =new Gson();

        MovieFullInfo movieFullInfo=jsonResponse.fromJson(responseResult,MovieFullInfo.class);
        if (movieFullInfo.getTitle()==null){ // check if exist movie or not
            throw new NotFoundMovieException("Movie with id ( "+imdbId+" ) not found");
        }
        return movieFullInfo;
    }

    public static MovieFullInfo getAllMovieDetailsByTitleAndYear(String movieTitle,String movieYear) throws NotFoundMovieException,JsonParseException {

        String requestUrl = "http://www.omdbapi.com/?t="+movieTitle+"&y="+movieYear+"&apikey="+apiKey;

        RestTemplate restTemplate=new RestTemplate();
        String responseResult =restTemplate.getForObject(requestUrl,String.class);

        if (responseResult == null) {
            throw new JsonParseException("Invalid request");
        }

        Gson jsonResponse =new Gson();
        MovieFullInfo movieFullInfo=jsonResponse.fromJson(responseResult,MovieFullInfo.class);

        if (movieFullInfo.getTitle()==null){  // check if exist movie or not
            throw new NotFoundMovieException("Movie with Title ( "+movieTitle+" ) and published at ( "+movieYear+" ) not found");
        }
        return movieFullInfo;
    }

}
