package com.photo.photogram.Service;

import com.photo.photogram.DTO.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    void signup(UserDTO userDTO) throws Exception;

}
