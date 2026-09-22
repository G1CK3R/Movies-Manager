package model;

import java.util.Objects;
public class Director {
    private String name;

    
    public Director(String name) {
        this.name = name;
    }

    public Director(Director director){
        this.name=director.name;
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
        Director other = (Director) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "Director: " + name + "\n"; 
    }

    
}
