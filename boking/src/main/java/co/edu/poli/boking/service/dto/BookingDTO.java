package co.edu.poli.boking.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookingDTO {
    private Long userId;
    private Long showtimeId;
    private List<Long> movieIds;
}
