package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    private final List<Movie> movieList;
    private final List<Director> directorList;
    private final HashMap<Movie, Director> movieDirectorHashMap;

    private final HashMap<Director, List<Movie>> directorListHashMap;

    public MovieRepository(List<Movie> movieList, List<Director> directorList, HashMap<Movie, Director> movieDirectorHashMap, HashMap<Director, List<Movie>> directorListHashMap) {
        this.movieList = movieList;
        this.directorList = directorList;
        this.movieDirectorHashMap = movieDirectorHashMap;
        this.directorListHashMap = directorListHashMap;
    }

    public String addMovie(Movie movie){
        movieList.add(movie);
        return "success";
    }

    public String addDirector(Director director){
        directorList.add(director);
        return "success";
    }

    public String addMovieDirectorPair(Movie movie, Director director){
        movieDirectorHashMap.put(movie, director);
        return "success";
    }

    public Movie getMovieByName(String movieName){
        Movie movie = new Movie();
        for(Movie movies : movieList){

            if(movies.getName().equals(movieName)){
                movie = movies;
                break;
            }
        }
       return movie;
    }

    public Director getDirectorByName(String directorName){

        Director director = new Director();

        for(Director directors : directorListHashMap.keySet()){

            if(directors.getName().equals(directorName)){
                director = directors;
                break;
            }
        }
        return director;
    }

    public List<Movie> getMoviesByDirectorName(String directorName){
        List<Movie> movieList1 = new ArrayList<>();
        for(Movie movie : movieDirectorHashMap.keySet()){
            if(movieDirectorHashMap.get(movie).getName().equals(directorName)){
                movieList1.add(movie);
            }
        }
        return movieList1;
    }
    public List<Movie> findAllMovies(){
        return movieList;
    }

    public String deleteDirectorByName(String directorName){

        for(Director dn : directorListHashMap.keySet()) {
            if(dn.getName().equals(directorName)){
                directorListHashMap.remove(dn);
            }
        }
        return "success";
    }

   public String deleteAllDirectors(){

        for(Director dn : directorListHashMap.keySet()){
            directorListHashMap.remove(dn);
        }
        return "success";
   }
}
