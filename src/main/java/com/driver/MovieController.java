package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

//    1;
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
//        movieService.movieRepository.getMovies();
//        System.out.println(movie);
        movieService.addMovie(movie);
//        movieService.movieRepository.getMovies();
        return  new ResponseEntity<>("success", HttpStatus.OK) ;
    }

//    2;
    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return  new ResponseEntity<>("success", HttpStatus.OK) ;
    }

//    3;
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair
    (@RequestBody String movieName,@RequestBody String directorName){
        movieService.directorMoviePair(movieName,directorName);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

//    4;
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getMovie(name),HttpStatus.OK);
    }

//    5;
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getDirector(name),HttpStatus.OK);
    }

//    6;
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(director),HttpStatus.OK);
    }

//    7;
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new  ResponseEntity<>(movieService.findAllMovies(),HttpStatus.OK);
    }

//    8;
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestBody String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

//    9;
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @GetMapping("/movies")
    public ResponseEntity<String> test(){
        return  new ResponseEntity<>("success", HttpStatus.OK) ;
//        return "Hi testing";
    }
}
