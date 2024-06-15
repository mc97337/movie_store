package co.edu.poli.showtime.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.commons.helper.Response;
import co.edu.poli.commons.helper.ResponseBuild;
import co.edu.poli.showtime.persistence.entity.Showtime;
import co.edu.poli.showtime.service.ShowtimeService;
import co.edu.poli.showtime.service.dto.ShowtimeDTO;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final ResponseBuild builder;

    @GetMapping
    public Response findAll(){
        return builder.success(showtimeService.findAll());
    }

    @PostMapping
    public Response save(@Valid @RequestBody ShowtimeDTO showtimeDTO, BindingResult result){
        if (result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        showtimeService.save(showtimeDTO);
        return builder.success(showtimeDTO);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        return builder.success(showtimeService.findById(id));
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable("id") Long id, @RequestBody ShowtimeDTO showtimeDTO) {
        Showtime showtime = (Showtime) findById(id).getData();
        if (showtime ==null){
            return builder.failed("Not found");
        }
        showtimeService.update(showtime,showtimeDTO);
        return builder.success(findById(id).getData());
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
