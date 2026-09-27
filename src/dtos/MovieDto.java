package dtos;
import java.util.Arrays;
import java.util.HashSet;
import model.Actor;
import model.Movie;
public class MovieDto {

    private String name;
    private String director;
    private String cast[];
    private float rating;

    public MovieDto(String name, String director, String[] cast, float rating) {
        this.name = name;
        this.director = director;
        this.rating = rating;

        this.cast = new String[cast.length];
     
        for(int i = 0; i < cast.length; i++){
            this.cast[i] = cast[i];
        }
    }

    public MovieDto(MovieDto movie){
        this(movie.getName(), movie.getDirector(),
        movie.getCast(), movie.getRating());
    }

    public MovieDto(Movie movie){
        this.name = movie.getName();
        this.director = movie.getDirector().getName();
        this.rating =  movie.getRating();

        HashSet<Actor> actors = movie.getCast();

        String actorNames[] = new String[actors.size()];

        int i = 0;

        for(Actor actor: actors){
            actorNames[i] = actor.getName();
            i++;
        }
        this.cast = actorNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String[] getCast() {
        String cast[] =  new String[this.cast.length];

        for(int i = 0; i < this.cast.length; i++){
            cast[i] = this.cast[i];
        }
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = new String[cast.length];

        for(int i = 0; i < cast.length; i++){
            this.cast[i] = cast[i];
        }

    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        String s = "";

        s += " Name: " + this.name + "\n";
        s += " Director: " + this.director + "\n";
        s += " Elenco: \n";

        for(String c : this.cast){
            s += "  " + c + "\n";
        }

        s += " Nota:" + this.rating + "\n";

        return s;
    }    

    public boolean validade() {
        if(this.director == "" || this.director == null)
            return false;
        else if(this.cast == null || this.cast.length == 0){
            return false;
        }else if(this.rating < 0)
            return false;

        return true;
    }
    

}
