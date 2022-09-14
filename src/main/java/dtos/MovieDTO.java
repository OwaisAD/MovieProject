package dtos;

import entities.Movie;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link entities.Movie} entity
 */
public class MovieDTO implements Serializable {
    private final Long id;
    private final int year;
    private final String title;
    private final String[] actors;

    public MovieDTO(Movie movie) {
        this.year = movie.getYear();
        this.title = movie.getTitle();
        this.actors = movie.getActors();
        this.id = movie.getId();
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

    public String[] getActors() {
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