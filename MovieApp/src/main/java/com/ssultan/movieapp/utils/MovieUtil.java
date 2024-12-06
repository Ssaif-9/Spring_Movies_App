package com.ssultan.movieapp.utils;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.ssultan.movieapp.exception.NotFoundMovieException;
import com.ssultan.movieapp.model.MovieFullInfo;
import org.springframework.web.client.RestTemplate;

public class MovieUtil {

    private static final String apiKey = "a5aa7cfa";

    public static String getAllMovieDetailsByImdbId(String imdbId,String movieType) throws NotFoundMovieException,JsonParseException {
        String requestUrl ="http://www.omdbapi.com/?i="+imdbId+"&plot="+movieType+"&apikey="+apiKey;


        RestTemplate restTemplate = new RestTemplate();
        Object responseResult =restTemplate.getForObject(requestUrl,Object.class);
        //try to delete
        if (responseResult == null) {
            throw new JsonParseException("Incorrect request");
        }
        Gson jsonResponse =new Gson();
        String serializedToken = jsonResponse.toJson(responseResult);
        MovieFullInfo movieFullInfo=jsonResponse.fromJson(serializedToken,MovieFullInfo.class);
        if (movieFullInfo.getTitle()==null){
            throw new NotFoundMovieException("Movie with id ( "+imdbId+" ) not found");
        }
        return serializedToken;
    }

    public static String getAllMovieDetailsByTitleAndYear(String movieTitle,String movieYear,String movieType) throws NotFoundMovieException,JsonParseException {
        String requestUrl = "http://www.omdbapi.com/?t="+movieTitle+"&y="+movieYear+"&plot="+movieType+"&apikey="+apiKey;

        RestTemplate restTemplate=new RestTemplate();
        String responseResult =restTemplate.getForObject(requestUrl,String.class);
        //try to delete
        if (responseResult == null) {
            throw new JsonParseException("Incorrect request");
        }

        Gson jsonResponse =new Gson();
        //String serializedToken=jsonResponse.toJson(responseResult);
        MovieFullInfo movieFullInfo=jsonResponse.fromJson(responseResult,MovieFullInfo.class);
        if (movieFullInfo.getTitle()==null){
            throw new NotFoundMovieException("Movie with Title ( "+movieTitle+" ) and published at ( "+movieYear+" ) not found");
        }
        return responseResult;
    }


}
