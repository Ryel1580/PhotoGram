package com.photo.photogram.api;


import com.photo.photogram.Config.auth.PrincipalDetails;
import com.photo.photogram.DTO.UserDTO;
import com.photo.photogram.Service.AuthService;
import com.photo.photogram.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @PutMapping("/api/user/{id}")
    public ResponseEntity<String> update(@PathVariable int id, UserDTO userDTO, @AuthenticationPrincipal PrincipalDetails principalDetails)throws Exception{
        logger.info(String.valueOf(userDTO));
        int result = userService.update(id, userDTO);
        if(result == 0){
            return new ResponseEntity<>("reslut : " +result, HttpStatus.BAD_REQUEST);
        }else{
            UserDTO selectuser = userService.selectUser(id);
            principalDetails.setUserDTO(selectuser);
            return new ResponseEntity<>("result : "+result, HttpStatus.OK);
        }
    }
}
