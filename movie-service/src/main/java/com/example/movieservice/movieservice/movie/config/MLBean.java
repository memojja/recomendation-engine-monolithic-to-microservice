package com.example.movieservice.movieservice.movie.config;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.recommendation.MatrixFactorizationModel;

//@Component
public class MLBean {

//    @Autowired
    private JavaSparkContext javaSparkContext;

//    @Bean
    public MatrixFactorizationModel getMLModel(){
        return MatrixFactorizationModel
                .load(javaSparkContext.sc(), "modell");
    }
}
