package co.edu.poli.showtime.service;

import co.edu.poli.showtime.mapper.ShowtimeDTOToShowtime;
import co.edu.poli.showtime.persistence.entity.Showtime;
import co.edu.poli.showtime.persistence.repository.ShowtimeRepository;
import co.edu.poli.showtime.service.dto.ShowtimeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final ShowtimeDTOToShowtime showtimeDTOtoShowtime;

    @Override
    @Transactional(readOnly = true)
    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ShowtimeDTO showtimeDTO) {
        showtimeRepository.save(showtimeDTOtoShowtime.mapper(showtimeDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public Showtime findById(Long id) {
        return showtimeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Showtime showtime, ShowtimeDTO showtimeDTO) {

        showtime.setDate(showtimeDTO.getDate());

        showtimeRepository.save(showtime);
    }
}
