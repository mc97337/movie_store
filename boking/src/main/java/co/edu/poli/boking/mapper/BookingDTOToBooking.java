package co.edu.poli.boking.mapper;

import co.edu.poli.boking.persistence.entity.Booking;
import co.edu.poli.boking.service.dto.BookingDTO;
import org.springframework.stereotype.Component;

@Component
public class BookingDTOToBooking implements IMapper<BookingDTO, Booking> {

    @Override
    public Booking mapper(BookingDTO bookingDTO){
        Booking booking = new Booking();

        booking.setUserId(bookingDTO.getUserId());
        booking.setShowtimeId(bookingDTO.getShowtimeId());
        booking.setMovieIds(bookingDTO.getMovieIds());

        return booking;
    }
}
