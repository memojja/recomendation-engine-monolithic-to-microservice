package com.example.movieservice.movieservice.client;

import com.example.movieservice.movieservice.model.Movie;
import com.example.movieservice.movieservice.model.Rating;
import com.example.movieservice.movieservice.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.Future;

@Component
public class RecomendationClient {

    @Autowired
    private RestTemplate restTemplate;

    @Async
    public List<Movie> getRecomendations(List<Rating> movies){

//        Movie movie = restTemplate.getForObject(AppConstant.recomendationService,Movie.class);
//        System.out.println("asdasdas"+movie.toString());

        HttpEntity request = new HttpEntity<>(movies);
        Movie[] recomendedMovies = restTemplate.postForObject(AppConstant.recomendationService, request, Movie[].class);
        System.out.println("sadsadsad"+recomendedMovies.toString());
        return Arrays.asList(recomendedMovies);
//        Movie[] movies= restTemplate.getForObject(AppConstant.recomendationService,Movie[].class);
//        return  Arrays.asList(movies);
    }

}
