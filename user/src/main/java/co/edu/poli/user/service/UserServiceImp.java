package co.edu.poli.user.service;

import co.edu.poli.user.mapper.UserDTOToUser;
import co.edu.poli.user.persistence.entity.User;
import co.edu.poli.user.persistence.repository.UserRepository;
import co.edu.poli.user.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final UserDTOToUser userDTOToUser;
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserDTO userDTO) {
        userRepository.save(userDTOToUser.mapper(userDTO));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
