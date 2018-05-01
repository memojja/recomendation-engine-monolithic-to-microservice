package com.jcombat.profile.controller;

import com.jcombat.profile.model.Movie;
import com.jcombat.profile.service.RecomendationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.*;
import com.jcombat.profile.model.Rating;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/")
@Log4j
@CrossOrigin("*")
public class RecomendationController {


    private final RecomendationService recomendationService;

    @Autowired
    public RecomendationController(RecomendationService recomendationService) {
        this.recomendationService = recomendationService;
    }

    @ApiOperation(value = "Get Recomendations", notes = "Create ratings for a user to recomentions movies")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Please check url")
    })
    @PostMapping("/recomendations")
    public Future<List<Movie>> handleRatings(@RequestBody List<Rating> ratings) throws ExecutionException, InterruptedException {
       System.out.println("sad");
        int userId = 1;
        return new AsyncResult<List<Movie>>(recomendationService.predictMovieToUserForOnlineLearning(ratings,userId).get());
    }

}
