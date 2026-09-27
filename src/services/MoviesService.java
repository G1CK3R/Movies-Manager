package services;

import java.util.HashSet;

import model.Director;
import model.Actor;
import model.Movie;
import repository.ActorRepository;
import repository.DirectorRepository;
import repository.MovieRepository;


public class MoviesService {

    private MovieRepository movieR;
    private ActorRepository actorR;
    private DirectorRepository directorR;

    public MoviesService(){
        this.movieR =  new MovieRepository();
        this.actorR =  new ActorRepository();
        this.directorR =  new DirectorRepository();
    }

    public boolean addMovie(String name, String directorName, 
        String actors [], float rating){

            Director newDirector =  new Director(directorName);
            this.directorR.addDirector(newDirector);

            HashSet<Actor> cast =  new HashSet<Actor>();
            
            for(String actorName: actors){
                Actor a = new Actor(actorName);
                this.actorR.addActor(a);
                cast.add(a);
            }

            Movie movie = new Movie(name, newDirector, cast, rating);

            

        return this.movieR.addMovie(movie);
    }

    
}