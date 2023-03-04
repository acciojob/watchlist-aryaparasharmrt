package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }

    public String addDirector(Director director){
         return movieRepository.addDirector(director);
    }

    public  String addMovieDirectorPair(Movie movie, Director director){
        return movieRepository.addMovieDirectorPair(movie, director);
    }

    public Movie getMovieByName(String movieName){
        return movieRepository.getMovieByName(movieName);
    }

    public Director getDirectorByName(String directorName){
        return movieRepository.getDirectorByName(directorName);
    }

    public List<Movie> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public List<Movie> getMoviesByDirectorName(String directorName){
        return movieRepository.getMoviesByDirectorName(directorName);
    }

    public String deleteDirectorByName(String directorName){
        return movieRepository.deleteDirectorByName(directorName);
    }

    public String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }

}
