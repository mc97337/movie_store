package co.edu.poli.showtime.service;

import co.edu.poli.showtime.persistence.entity.Showtime;
import co.edu.poli.showtime.service.dto.ShowtimeDTO;

import java.util.List;

public interface ShowtimeService {

    List<Showtime> findAll();
    void save(ShowtimeDTO showtimeDTO);
    Showtime findById(Long id);
    void update(Showtime showtime,ShowtimeDTO showtimeDTO);
}
