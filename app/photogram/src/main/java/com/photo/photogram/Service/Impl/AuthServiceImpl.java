package com.photo.photogram.Service.Impl;

import com.photo.photogram.DAO.AuthDAO;
import com.photo.photogram.DTO.UserDTO;
import com.photo.photogram.Handler.ex.CustomValidationException;
import com.photo.photogram.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


@Service
@RequiredArgsConstructor // final 로 정의된 필드에 관해 생성자 자동 생성
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthDAO authDAO;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void signup(UserDTO userDTO){

            String rawPassword = userDTO.getPw(); // 기존 pw 를 암호화
            String encPassword = bCryptPasswordEncoder.encode(rawPassword); // 암호화된 패스워드 디코딩
            userDTO.setPw(encPassword);
            logger.info("User SignUp RcvData=======================================================================================");
            logger.info(String.valueOf(userDTO));
            logger.info("=======================================================================================");
            authDAO.signup(userDTO);

    }
}