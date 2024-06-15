package co.edu.poli.movie.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Range;


import java.util.Objects;

@Data
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "El titulo no puede ser vacio")
    @Column(name = "title")
    private String title;

    @NotEmpty(message = "El director no puede ser vacio")
    @Column(name = "director")
    private String director;

    @Range(min = 1, max = 5, message = "El rating debe estar entre 1 y 5")
    @Column(name="rating")
    private int rating;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}