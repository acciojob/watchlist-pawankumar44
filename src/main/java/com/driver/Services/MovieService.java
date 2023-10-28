package com.driver.Services;

import com.driver.Models.Movie;
import com.driver.Repositries.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
}
