package co.edu.poli.movie.service;

import co.edu.poli.movie.persistence.entity.Movie;
import co.edu.poli.movie.service.dto.MovieDTO;

import java.util.List;

public interface MoveService {

    List<Movie> findAll();
    void save(MovieDTO movieDTO);
    Movie findById(Long id);
    void delete(Movie movie);
}
