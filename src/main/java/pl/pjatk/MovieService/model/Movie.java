package pl.pjatk.MovieService.model;

public class Movie {

    private Long id;
    private String name;
    private MovieCategory movieCategory;
    private int yearOfProduction;

    public Movie(Long id, String name, MovieCategory movieCategory, int yearOfProduction) {
        this.id = id;
        this.name = name;
        this.movieCategory = movieCategory;
        this.yearOfProduction = yearOfProduction;
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

    public MovieCategory getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(MovieCategory movieCategory) {
        this.movieCategory = movieCategory;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movieCategory=" + movieCategory +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}

