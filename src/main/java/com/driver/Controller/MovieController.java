package com.driver.Controller;

import com.driver.Models.Movie;
import com.driver.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public String addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return "Movie added";
    }

    @GetMapping("/movies")
    public String test(){
        return "Hi testing";
    }
}
