package com.driver.Repositries;

import com.driver.Movie;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MovieRepository {
    private HashMap<String,Movie> movieDb;

    public MovieRepository(){
        movieDb = new HashMap<>();
    }

    public void addMovie(Movie movie){
        this.movieDb.put(movie.getName(),movie);
    }
}
