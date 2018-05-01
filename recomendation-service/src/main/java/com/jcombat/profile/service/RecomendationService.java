package com.jcombat.profile.service;

import com.jcombat.profile.model.Rating;
import com.jcombat.profile.model.Movie;


import java.util.List;
import java.util.concurrent.CompletableFuture;


public interface RecomendationService {
//    List<Movie> predictMovieToUserForOnlineLearning(List<Rating> ratings,int userId);
    CompletableFuture<List<Movie>> predictMovieToUserForOnlineLearning(List<Rating> ratings, int userId);
}
