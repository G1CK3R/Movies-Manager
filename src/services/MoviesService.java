package services;

import java.util.HashSet;

import model.Director;
import model.Actor;
import model.Movie;
import repository.ActorRepository;
import repository.DirectorRepository;
import repository.MovieRepository;


public class MoviesService {

    private MovieRepository fr;
    private ActorRepository ar;
    private DirectorRepository dr;

    public MoviesService(){
        this.fr =  new MovieRepository();
        this.ar =  new ActorRepository();
        this.dr =  new DirectorRepository();
    }

    public boolean addMovie(String name, String directorName, 
        String actors [], float rating){

            Director d =  new Director(directorName);
            this.dr.addDirector(d);

            HashSet<Actor> cast =  new HashSet<Actor>();
            
            for(String actorName: actors){
                Actor a = new Actor(actorName);
                this.ar.addActor(a);
                cast.add(a);
            }

            Movie movie = new Movie(name, d, cast, rating);

            

        return this.fr.addMovie(movie);
    }

    
}