package co.edu.poli.user.service;

import co.edu.poli.user.persistence.entity.User;
import co.edu.poli.user.service.dto.UserDTO;

import java.util.List;
public interface UserService {

    List<User> findAll();
    void save(UserDTO userDTO);
    void delete(User user);
    User findById(Long id);
}
