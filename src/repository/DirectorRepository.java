package repository;

import java.util.HashSet;
import java.util.Iterator;

import model.Director;

public class DirectorRepository {
    
    private HashSet<Director> directors;

    public DirectorRepository() {
        this.directors = new HashSet<Director>();
    }

    public boolean addDirector(Director director){
        return this.directors.add(director);
    }

    public HashSet<Director> getDirectors(){
        return new HashSet<Director>(directors);
    }

    public Director getDirector(String name){
        Director director =   null;

        Iterator<Director> iterator = directors.iterator();
    
        for(Director d = null; iterator.hasNext(); d = iterator.next()){
            if(d.getName().equals(name)){
                director = new Director(d);
                break;
            }
        }
        return director;
    }
}