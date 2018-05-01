package com.example.movieservice.movieservice.movie;

import com.example.movieservice.movieservice.MovieServiceApplication;
import com.example.movieservice.movieservice.movie.controller.MovieController;
import com.example.movieservice.movieservice.movie.model.Movie;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieServiceApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerIT {

    @LocalServerPort
    private int port;
    TestRestTemplate testRestTemplate = new TestRestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();

    @Test
    @Ignore
    public void retrieveMovies() throws Exception {

        HttpEntity<String> httpEntity = new HttpEntity<String>(null,httpHeaders);
        ResponseEntity<String> response = testRestTemplate.exchange(
                createURLWithPort("/movies/1"),
                HttpMethod.GET,httpEntity,String.class);

        String expected = "{\"_id\":\"1\",\"_class\":\"com.example.movieservice.movieservice.movie.model.Movie\",\"imdbId\":\"0114709\",\"tmdbId\":\"862\",\"name\":\"Toy Story (1995)\",\"url\":\"/rhIRbceoE9lR4veEXuwCC2wARtG.jpg\",\"overview\":\"Led by Woody, Andy's toys live happily in his room until Andy's birthday brings Buzz Lightyear onto the scene. Afraid of losing his place in Andy's heart, Woody plots against Buzz. But when circumstances separate Buzz and Woody from their owner, the duo eventually learns to put aside their differences.\",\"releaseDate\":\"1995-10-30\",\"homepage\":\"http://toystory.disney.com/toy-story\",\"video\":\"false\"}";
        System.out.println("asasas"+response.getBody());
        JSONAssert.assertEquals(expected,response.getBody(),true);

    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
