package com.driver;

import com.driver.Movie;
import com.driver.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;//can't invoke constructor, don't need constructor for bean

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    public Movie getMovie(String name){
        return movieRepository.getMovie(name);
    }

    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    public Director getDirector(String name){
        return movieRepository.getDirector(name);
    }



}
