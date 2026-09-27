package model;

import java.util.HashSet; 
public class Movie {
    private String name;
    private Director director;
    private HashSet<Actor> cast;
    private float rating;

    
    public Movie(String name, Director director,
        HashSet<Actor> cast, float rating) {
        this.name = name;
        this.director = director;
        this.cast = cast;
        this.rating = rating;
    }
    public Movie(Movie movie) {
		this.name = movie.getName();
		this.director = new Director(movie.getDirector());
		this.cast = movie.getCast();
		this.rating = movie.getRating();
	}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = new Director(director);
    }
    public HashSet<Actor> getCast() {
        return new HashSet<Actor>(cast);
    }
    public void setCast(HashSet<Actor> cast) {
        this.cast = cast;
    }
    public float getRating() {
        return rating;
    }
    public void setNota(float rating) {
        this.rating = rating;
    }

    
}
