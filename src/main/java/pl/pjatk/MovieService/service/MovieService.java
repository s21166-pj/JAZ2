package pl.pjatk.MovieService.service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.exception.MovieException;
import pl.pjatk.MovieService.model.Movie;
import pl.pjatk.MovieService.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll() throws MovieException {
        if (movieRepository.findAll().isEmpty()) {
            throw new MovieException("There are no movies");
        }
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Long id) throws MovieException {
        if (id < 0) {
            throw new MovieException("There are no negative IDs");
        } else if (movieRepository.findById(id).isEmpty()) {
            throw new MovieException("No movie with ID: " + id);
        } else {
            return movieRepository.findById(id);
        }
    }

    public Movie createNewMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movieToUpdate, Long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            movie.setName(movieToUpdate.getName());
            movie.setCategory(movieToUpdate.getCategory());
            return movieRepository.save(movie);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) throws MovieException {
        if (movieRepository.findById(id).isPresent()) {
            movieRepository.deleteById(id);
        } else {
            throw new MovieException("There is no movie to delete");
        }
    }

    public void updateMovieAvailability(Long id) {
        movieRepository.updateAvailabilityToTrue(id);
    }
}
