package services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;

import dtos.MovieDto;
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

    public boolean addMovie(MovieDto movieDto) {
		return this.addMovie(movieDto.getName(), movieDto.getDirector(),
				movieDto.getCast(), movieDto.getRating());
	}
	
	public List<MovieDto> listMoviesByName(){
		List<Movie> filteredMovies = new ArrayList<Movie>(
				this.movieR.getMovies() );
		
		filteredMovies.sort((o1, o2) -> {
				return o1.getName().compareTo(o2.getName());
		});
		
		return ConvertFilmListToDto(filteredMovies);
	}

	private List<MovieDto> ConvertFilmListToDto(List<Movie> filmes){
		List<MovieDto> filmesDto = new ArrayList<MovieDto>();
		
		for(Movie f : filmes) {
			filmesDto.add(new MovieDto(f));
		}
		
		return filmesDto;		
	}

	public List<MovieDto> listaFilmesPorDiretor(String diretor){
		
		ArrayList<Movie> filteredMoviess = new ArrayList<Movie>();
		
		HashSet<Movie> filmes = this.movieR.getMovies();
		
		Iterator<Movie> i = filmes.iterator();
		
		while(i.hasNext()) {
			Movie f = i.next();
			
			if(f.getDirector().getName().equals(diretor)) {
				filteredMoviess.add(new Movie(f));
			}
		}
		
		return convertMoviesToDto(filteredMoviess);
	}
	
	public List<MovieDto> listaFilmesPorActor(String Actor){
		
		ArrayList<Movie> filteredMoviess = new ArrayList<Movie>();
		
		HashSet<Movie> filmes = this.movieR.getMovies();
		
		Iterator<Movie> i = filmes.iterator();
		
		while(i.hasNext()) {
			Movie f = i.next();
			
			Iterator<Actor> j = f.getCast().iterator();
			
			while(j.hasNext()) {				
				Actor a = j.next();
				
				if(a.getName().equals(Actor)) {
					filteredMoviess.add(new Movie(f));
					break;
				}				
			}
		}
		
		return convertMoviesToDto(filteredMoviess);
	}
	
	public List<MovieDto> listaFilmesPorNota(float nota){
		ArrayList<Movie> filteredMoviess = new ArrayList<Movie>();
		
		HashSet<Movie> filmes = this.movieR.getMovies();
		
		for(Movie f : filmes) {
			if(f.getRating() >= nota)
				filteredMoviess.add(f);
		}
		
		return convertMoviesToDto(filteredMoviess);
	}
	
	private List<MovieDto> convertMoviesToDto(List<Movie> filmes){
		List<MovieDto> filmesDto = new ArrayList<MovieDto>();
		
		for(Movie f : filmes) {
			filmesDto.add(new MovieDto(f));
		}
		
		return filmesDto;		
	}
	
	public boolean addActor(String nome) {
		return this.actorR.addActor(new Actor(nome));
	}
	
	public boolean removeActor(String nome) {
		return this.actorR.removeActor(new Actor(nome));
	}
	
	public Actor getActor(String nome) {
		return actorR.getActor(nome);
	}
	
	public ArrayList<String> listaActores(){
		HashSet<Actor> ActoresArray = this.actorR.getActors();	
		
		ArrayList<String> Actores = new ArrayList<>();
		
		for(Actor a : ActoresArray)
			Actores.add(a.getName());
		
		return Actores;
	}
	
	public boolean addDirector(String nome) {
		return this.directorR.addDirector(new Director(nome));
	}
	
	public boolean removeDirector(String nome) {
		return this.directorR.removeDirector(new Director(nome));
	}
	
	public ArrayList<String> listaDiretores(){
		
		HashSet<Director> diretoresArray = this.directorR.getDirectors();
		
		ArrayList<String> diretores = new ArrayList<String>();
		
		for(Director d : diretoresArray)
			diretores.add(d.getName());
		
		return diretores;
	}
    
}