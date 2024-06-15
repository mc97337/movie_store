package co.edu.poli.boking.service;

import co.edu.poli.boking.persistence.entity.Booking;
import co.edu.poli.boking.service.dto.BookingDTO;

import java.util.List;
public interface BookingSrvice {

    List<Booking> findAll();
    void save(BookingDTO bookingDTO);
    void delete(Booking booking);
    Booking findById(Long id);

    Booking findByUserId(Long id);
}
