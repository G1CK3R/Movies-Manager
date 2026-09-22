package repository;

import java.util.HashSet;
import java.util.Iterator;

import model.Actor;
public class ActorRepository {

    private HashSet<Actor> actors;

    public ActorRepository(HashSet<Actor> actors) {
        this.actors = new HashSet<Actor>();
    }

    public HashSet<Actor> getActors() {
        return new HashSet<Actor>(this.actors);
    }

    public boolean addActor(Actor actor){
        return this.actors.add(actor);
    }

    public Actor getActor(String name){
        Actor a =  null;

        Iterator<Actor> actor =  actors.iterator();

        for(Actor i = null; actor.hasNext(); i = actor.next()){
            
            if(i.getName().equals(name)){
                a = new Actor(i);
                break;
            }
        }
        return a;
    }
}
