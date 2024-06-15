package co.edu.poli.user.mapper;

import co.edu.poli.user.persistence.entity.User;
import co.edu.poli.user.service.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDTOToUser implements IMapper<UserDTO, User> {

    @Override
    public User mapper(UserDTO userDTO){
        User user = new User();

        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());

        return user;
    }
}
