package pl.pjatk.MovieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import pl.pjatk.MovieService.model.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findById(Long id);

    List<Movie> findAll();

    Movie save(Movie movie);

    @Modifying
    @Transactional
    @Query(value = "UPDATE movie m SET m.isAvailable = true WHERE m.ID = :id ", nativeQuery = true)
    void updateAvailabilityToTrue(Long id);
}
