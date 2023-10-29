package com.driver;

import com.driver.Movie;
import com.driver.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void directorMoviePair(String movieName,String directorName){
        movieRepository.directorMoviePair(movieName,directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName){
        return movieRepository.getMoviesByDirectorName(directorName);
    }

    public List<String> findAllMovies (){
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName (String name){
        movieRepository.deleteDirectorByName(name);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }


}
