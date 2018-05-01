package com.example.movieservice.movieservice.service;

import com.example.movieservice.movieservice.model.Rating;

import java.util.List;

public interface RatingService {
    void save(Rating rating);
    void saveRatings(List<Rating> ratingList);
}
