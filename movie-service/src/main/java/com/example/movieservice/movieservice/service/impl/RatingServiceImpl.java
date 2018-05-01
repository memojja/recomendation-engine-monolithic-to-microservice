package com.example.movieservice.movieservice.service.impl;

import com.example.movieservice.movieservice.model.Rating;
import com.example.movieservice.movieservice.repository.mongo.RatingRepository;
import com.example.movieservice.movieservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public void save(Rating rating) {
        ratingRepository.save(rating);
    }

    @Override
    public void saveRatings(List<Rating> ratingList) {
        ratingRepository.save(ratingList);
    }

}
