package com.photo.photogram.Service;


import com.photo.photogram.DTO.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public interface UserService {

    int update(int id, UserDTO userDTO);

    UserDTO selectUser(int id);
}
