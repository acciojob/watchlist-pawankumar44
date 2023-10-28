package com.driver;

import com.driver.Movie;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MovieRepository {
    private HashMap<String,Movie> movieDb = new HashMap<>();
    private HashMap<String,Director> directorDb = new HashMap<>();

    public void addMovie(Movie movie){
        this.movieDb.put(movie.getName(),movie);
    }

    public Movie getMovie(String name){
        return movieDb.getOrDefault(name, null);
    }

    public void addDirector(Director director){
        this.directorDb.put(director.getName(),director);
    }

    public Director getDirector(String name){
        return directorDb.getOrDefault(name, null);
    }

    public void getDirectors(){
        System.out.println(directorDb);
    }

    public void getMovies(){
        System.out.println(movieDb);
    }
}
