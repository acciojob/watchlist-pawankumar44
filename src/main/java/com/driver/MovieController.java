package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
//        movieService.movieRepository.getMovies();
//        System.out.println(movie);
        movieService.addMovie(movie);
//        movieService.movieRepository.getMovies();
        return  new ResponseEntity<>("success", HttpStatus.OK) ;
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return  new ResponseEntity<>("success", HttpStatus.OK) ;
    }

    @PutMapping("/movies/add-movie-director-pair")
    public String addMovieDirectorPair(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return "Movie added";
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getMovie(name),HttpStatus.OK);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getDirector(name),HttpStatus.OK);
    }
//
//    @PostMapping("/movies/add-movie")
//    public String findAllMovies(@RequestBody Movie movie){
//        movieService.addMovie(movie);
//        return "Movie added";
//    }
//
//    @PostMapping("/movies/add-movie")
//    public String deleteDirectorByName(@RequestBody Movie movie){
//        movieService.addMovie(movie);
//        return "Movie added";
//    }
//
//    @PostMapping("/movies/add-movie")
//    public String deleteAllDirectors(@RequestBody Movie movie){
//        movieService.addMovie(movie);
//        return "Movie added";
//    }

    @GetMapping("/movies")
    public ResponseEntity<String> test(){
        return  new ResponseEntity<>("success", HttpStatus.OK) ;
//        return "Hi testing";
    }
}
