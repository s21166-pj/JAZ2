package pl.pjatk.MovieService.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.MovieService.exception.MovieException;
import pl.pjatk.MovieService.model.Movie;
import pl.pjatk.MovieService.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() throws MovieException {
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> findById(@PathVariable Long id) throws MovieException {
        Optional<Movie> findById = movieService.findById(id);
        if (findById.isPresent()) {
            return ResponseEntity.ok(findById);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.createNewMovie(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable Long id) {
        return ResponseEntity.ok(movieService.updateMovie(movie, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) throws MovieException {
        movieService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/availability/{id}")
    public ResponseEntity<Void> updateMovieAvailability(@PathVariable Long id) {
        movieService.updateMovieAvailability(id);
        return ResponseEntity.noContent().build();
    }
}
