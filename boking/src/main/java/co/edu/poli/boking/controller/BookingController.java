package co.edu.poli.boking.controller;

import co.edu.poli.commons.helper.Response;
import co.edu.poli.commons.helper.ResponseBuild;
import co.edu.poli.boking.persistence.entity.Booking;
import co.edu.poli.boking.service.BookingSrvice;
import co.edu.poli.boking.service.dto.BookingDTO;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingSrvice bookingService;
    private final ResponseBuild builder;

    @GetMapping
    public Response findAll(){
        return builder.success(bookingService.findAll());
    }

    @PostMapping
    public Response save(@Valid @RequestBody BookingDTO bookingDTO, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        bookingService.save(bookingDTO);
        return builder.success(bookingDTO);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Booking booking = (Booking)  findById(id).getData();
        if(booking == null){
            return builder.failed("Not found");
        }
        bookingService.delete(booking);
        return builder.success(booking);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        return builder.success(bookingService.findById(id));
    }


    @GetMapping("/{userId}")
    public Response findByUserId(@PathVariable("userId") Long id){
        return builder.success(bookingService.findByUserId(id));
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
