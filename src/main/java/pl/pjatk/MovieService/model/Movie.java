package pl.pjatk.MovieService.model;
import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private MovieCategory category;
    private boolean isAvailable = false;

    public Movie(Long id, String name, MovieCategory category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Movie(Long id, String name, MovieCategory category, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieCategory getCategory() {
        return category;
    }

    public void setCategory(MovieCategory movieCategory) {
        this.category = movieCategory;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

