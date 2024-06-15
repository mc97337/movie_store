package co.edu.poli.movie.mapper;

import co.edu.poli.movie.persistence.entity.Movie;
import co.edu.poli.movie.service.dto.MovieDTO;
import org.springframework.stereotype.Component;

@Component
public class MovieDTOToMovie implements IMapper<MovieDTO, Movie>{

    @Override
    public Movie mapper(MovieDTO movieDTO){
        Movie movie = new Movie();

        movie.setTitle(movieDTO.getTitle());
        movie.setDirector(movieDTO.getDirector());
        movie.setRating(movieDTO.getRating());

        return movie;
    }
}
