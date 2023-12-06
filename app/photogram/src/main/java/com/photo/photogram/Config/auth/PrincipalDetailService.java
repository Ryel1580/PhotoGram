package com.photo.photogram.Config.auth;


import com.photo.photogram.DAO.UserDAO;
import com.photo.photogram.DTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    // 로그인 프로세스가 실행시 UserDetailService 가 낚아챔

    @Autowired
    UserDAO userDAO;

    @Autowired
    UserDTO userDTO;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("====================RcvData====================");
        logger.info("EMAIL" + userDTO.getEmail());
        logger.info("PW" + userDTO.getPw());
        logger.info("===============================================");

        UserDTO result = userDAO.selectLogin(userDTO);

        if (result != null) {
            logger.info("==========Result Data==========");
            logger.info("ID" +result.getUserId());
            logger.info("EMAIL" + result.getEmail());
            logger.info("PW" + result.getPw());
            logger.info("===============================");

            return new PrincipalDetails(userDTO);

        } else {
            logger.info("==========Result Data: Login Failed==========");
        }
        return null;
    }
}