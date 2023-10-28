package com.driver.Repositries;

import com.driver.Models.Movie;

import java.util.HashMap;

public class MovieRepository {
    private HashMap<String,Movie> movieDb;

    public MovieRepository(){
        movieDb = new HashMap<>();
    }

    public void addMovie(Movie movie){
        this.movieDb.put(movie.getName(),movie);
    }
}
