package co.edu.poli.boking.persistence.entity;

import co.edu.poli.boking.model.Showtime;
import co.edu.poli.boking.model.User;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;
import java.util.Objects;
@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Transient
    private User user;

    @Column(name = "showtimeId")
    private Long showtimeId;

    @Transient
    private Showtime showtime;

    @ElementCollection
    private List<Long> movieIds;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}