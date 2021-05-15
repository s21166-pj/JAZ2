package pl.pjatk.MovieService.service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.model.Movie;
import pl.pjatk.MovieService.model.MovieCategory;

import java.util.List;

@Service
public class MovieService {

    public List<Movie> findAllMovies() {
        return List.of(
                new Movie(1L, "Gladiator", MovieCategory.DRAMA, 2000),
                new Movie(2L, "Harry Potter", MovieCategory.FANTASY, 2001)
        );
    }

    public Movie findMovieById(Long id) {
        return new Movie(2L, "Die Hard", MovieCategory.THRILLER, 1988);
    }

    public Movie createNewMovie(Movie movie) {
        return movie;
    }

    public Movie updateMovie(Movie movie, Long id) {
        return new Movie(id, movie.getName(), movie.getMovieCategory(), movie.getYearOfProduction());
    }

    public void deleteMovie(Long id) {
        System.out.println("No movie hehehe");
    }
}
