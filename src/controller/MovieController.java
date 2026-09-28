package controller;

import java.util.List;
import dtos.MovieDto;
import services.MoviesService;

public class MovieController {
    private MoviesService movieS;

    public MovieController() {
        this.movieS = new MoviesService();
    }

    public boolean addMovie(MovieDto movieDto){
        if(!movieDto.validate())
            return false;
        return movieS.addMovie(movieDto);
    }

    public  List<MovieDto> listMoviesByName(){
        return movieS.listMoviesByName();
    }

    public List<MovieDto> listMoviesByDirector(String directorName){
        return movieS.listMoviesByDirector(directorName);
    }

    public List<MovieDto> listMoviesByActor(String actorName){
        return movieS.listMoviesByActor(actorName);
    }

    public List<MovieDto> listMovieByRating(float rating){
        return movieS.listMoviesByRating(rating);
    }

    public List<String> listActors(){
        return movieS.listActors();
    }
    


}
