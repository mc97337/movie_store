package co.edu.poli.movie.controller;

import co.edu.poli.commons.helper.Response;
import co.edu.poli.commons.helper.ResponseBuild;
import co.edu.poli.movie.persistence.entity.Movie;
import co.edu.poli.movie.service.MoveService;
import co.edu.poli.movie.service.dto.MovieDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MoveService movieService;
    private final ResponseBuild builder;

    @GetMapping
    public Response findAll(){
        return builder.success(movieService.findAll());
    }

    @PostMapping
    public Response save(@Valid @RequestBody MovieDTO movieDTO, BindingResult result){
        if (result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        movieService.save(movieDTO);
        return builder.success(movieDTO);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        return builder.success(movieService.findById(id));
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Movie movie = (Movie) findById(id).getData();
        if (movie==null){
            return builder.failed("Not found");
        }
        movieService.delete(movie);
        return builder.success(movie);
    }

    private List<Map<String, String>> formatMessage(BindingResult result) {
        return result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
    }
}
