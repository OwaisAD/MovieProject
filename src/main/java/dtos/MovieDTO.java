package dtos;

import entities.Movie;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link entities.Movie} entity
 */
public class MovieDTO implements Serializable {
    private final Long id;
    private final int year;
    private final String title;
    @ElementCollection
    @Column(name = "actor")
    private final List<String> actors;

    public MovieDTO(Movie movie) {
        this.year = movie.getYear();
        this.title = movie.getTitle();
        this.actors = movie.getActors();
        this.id = movie.getId();
    }


    public static List<MovieDTO> getDtos(List<Movie> movies) {
        List<MovieDTO> moviesdtos = new ArrayList<>();
        movies.forEach(movie -> moviesdtos.add(new MovieDTO(movie)));
        return moviesdtos;
    }

    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getActors() {
        return actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO entity = (MovieDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.year, entity.year) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.actors, entity.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, title, actors);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "year = " + year + ", " +
                "title = " + title + ", " +
                "actors = " + actors + ")";
    }
}