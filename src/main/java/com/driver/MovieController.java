package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public String addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @PostMapping("/add-director")
    public String addDirector(@RequestBody Director director){
        return movieService.addDirector(director);
    }

    @PostMapping("/add-Movie-Director-Pair")
    public String addMovieDirectorPair(@RequestBody Movie movie, @RequestBody Director director){
        return movieService.addMovieDirectorPair(movie, director);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public  Movie getMovieByName(@PathVariable("name") String movieName){
        return movieService.getMovieByName(movieName);
    }

    @GetMapping("/get-director-by-name/{name}")
    public Director getDirectorByName(@PathVariable("name") String directorName){
        return movieService.getDirectorByName(directorName);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public List<Movie> getMoviesByDirectorName(@PathVariable("director") String directorName){
        return movieService.getMoviesByDirectorName(directorName);
    }

    @GetMapping("/get-all-movies")
    public List<Movie> findAllMovies(){
        return movieService.findAllMovies();
    }

    @DeleteMapping("/delete-director-by-name")
    public String deleteDirectorByName(@RequestParam String directorName){
        return deleteDirectorByName(directorName);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public String deleteDirectorByName(){
        return movieService.deleteAllDirectors();
    }

}
