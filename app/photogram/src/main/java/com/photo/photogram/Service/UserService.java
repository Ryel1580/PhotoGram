package com.photo.photogram.Service;

import com.photo.photogram.DTO.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDTO login(UserDTO userDTO);

    void signup(UserDTO userDTO);

}
