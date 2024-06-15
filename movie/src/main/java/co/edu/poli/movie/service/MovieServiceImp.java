package co.edu.poli.movie.service;

import co.edu.poli.movie.mapper.MovieDTOToMovie;
import co.edu.poli.movie.persistence.entity.Movie;
import co.edu.poli.movie.persistence.repository.MovieRepository;
import co.edu.poli.movie.service.dto.MovieDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImp implements MoveService{

    private final MovieRepository movieRepository;
    private final MovieDTOToMovie movieDTOToMovie;

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(MovieDTO movieDTO) {
        movieRepository.save(movieDTOToMovie.mapper(movieDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }
}
