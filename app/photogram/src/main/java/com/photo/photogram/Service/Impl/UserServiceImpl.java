package com.photo.photogram.Service.Impl;

import com.photo.photogram.DAO.UserDAO;
import com.photo.photogram.DTO.UserDTO;
import com.photo.photogram.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder encoder;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    @Override
    @Transactional
    public int update(int id ,UserDTO userDTO){
        logger.info("====================RcvData====================");
        logger.info(String.valueOf(userDTO));
        logger.info("===============================================");
        // 비밀번호 암호화
        userDTO.setPw(encoder.encode(userDTO.getPw()));
        int result = userDAO.update(userDTO);
        logger.info(String.valueOf(result));
        return result;
    }


    @Override
    public UserDTO selectUser(int id) {
        UserDTO selectUser = userDAO.selectUser(id);
        return selectUser;
    }

}
