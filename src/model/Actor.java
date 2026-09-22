package model;

import java.util.Objects;

public class Actor {
    private String name;

    public Actor(String name) {
        this.name = name;
    }

    public Actor(Actor actor){
        this.name = actor.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     @Override 
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override 
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if (obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Actor other = (Actor) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "Actor: " + name + "\n"; 
    }

}
