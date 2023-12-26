package com.photo.photogram.DAO;

import com.photo.photogram.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AuthDAO {
    UserDTO selectLogin(String email);
    boolean signup (UserDTO userDTO);
}
