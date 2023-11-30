package com.photo.photogram.Controller;

import com.photo.photogram.DTO.UserDTO;
import com.photo.photogram.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Controller //파일을 응답하는 컨트롤러
//@RestController // Data 를 응답하는 컨트롤러
@RequestMapping(value = "/auth" )

public class UserController {

    String url = "auth";
    @Autowired
    UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping("/login")
    public String login() throws Exception{
        logger.info("auth/login Call");
        return url+"/login";
    }

    @PostMapping("/login.json")
    public ResponseEntity<String> login(@Valid UserDTO userDTO , BindingResult bindingResult, HttpServletRequest request) throws Exception{

        // validation 체크
        if (bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<>();

            for (FieldError error :bindingResult.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());
                logger.info("====================================");
                logger.info(error.getDefaultMessage());
                logger.info("====================================");
            }

        }
        try{
            HttpSession session = request.getSession();
            UserDTO result = userService.login(userDTO);
            session.setAttribute("userInfo", result);

            return new ResponseEntity<>("result : " + result , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/signup")
    public String signUp() throws Exception{
        logger.info(url+"/signup Call");
        return url+"/signup";
    }

    @PostMapping("/signup.json")
    public ResponseEntity<String> signUpJson(@RequestBody UserDTO userDTO)throws Exception{
        logger.info(String.valueOf(userDTO));

        try{
            userService.signup(userDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("result : " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
