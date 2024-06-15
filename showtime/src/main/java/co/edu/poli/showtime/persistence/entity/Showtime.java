package co.edu.poli.showtime.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "showtime")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "La fecha no puede ser vacia")
    @Column(name = "date")
    private Date date;

    @ElementCollection
    private List<Long> movieIds;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showtime showtime = (Showtime) o;
        return Objects.equals(id, showtime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
