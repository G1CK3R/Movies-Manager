package repository;
import model.Movie;
import java.util.HashSet;

public class MovieRepository {
    
    private HashSet<Movie> movies;

    public MovieRepository() {
        this.movies =  new HashSet<Movie>();
    }

    public boolean addFilme(Movie movie){
        return this.movies.add(movie);
    }

    public boolean removeMovie(Movie movie){
        return this.movies.remove(movie);
    }

    public HashSet<Movie> getMovies(){
        return new HashSet<Movie>(this.movies);
    }
}
