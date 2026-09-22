package model;

import java.util.HashSet; 
public class Movie {
    private String name;
    private Director director;
    private HashSet<Actor> cast;
    private float nota;

    
    public Movie(String name, Director director,
        HashSet<Actor> cast, float nota) {
        this.name = name;
        this.director = director;
        this.cast = cast;
        this.nota = nota;
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
    public float getNota() {
        return nota;
    }
    public void setNota(float nota) {
        this.nota = nota;
    }

    
}
