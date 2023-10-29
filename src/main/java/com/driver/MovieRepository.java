package com.driver;

import com.driver.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String,Movie> movieDb = new HashMap<>();
    private HashMap<String,Director> directorDb = new HashMap<>();

    //to store director movie pair
    private HashMap<String, HashSet<String>> directorMovie = new HashMap<>();

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

    public void directorMoviePair(String movieName, String directorName){
        HashSet<String> st = directorMovie.getOrDefault(directorName, new HashSet<>());
        st.add(movieName);
        directorMovie.put(directorName,st);
    }

    public List<String> getMoviesByDirectorName(String directorName){
        List<String> ans = new ArrayList<>();
        for(String name : directorMovie.keySet()){
            HashSet<String> st = directorMovie.get(name);
            ans.addAll(st);
        }
        return ans;
    }

    public List<String> findAllMovies (){
        return new ArrayList<>(movieDb.keySet());
    }

    //delete director and his movies
    public void deleteDirectorByName (String name){
        HashSet<String> st = directorMovie.getOrDefault(name,new HashSet<>());
        directorMovie.remove(name);
        for (String movieName : st) {
            movieDb.remove(movieName);
        }
        directorDb.remove(name);
    }

    //delete all directors and his movies
    public void deleteAllDirectors(){
        for(String dirName : directorDb.keySet()){
            directorDb.remove(dirName);
            HashSet<String> hisMovies = directorMovie.getOrDefault(dirName,new HashSet<>());
            for(String movie : hisMovies){
                movieDb.remove(movie);
            }
            directorMovie.remove(dirName);
        }
    }

}
