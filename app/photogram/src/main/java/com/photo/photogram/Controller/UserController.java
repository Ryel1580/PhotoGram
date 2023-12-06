package com.photo.photogram.Controller;

import com.photo.photogram.DTO.UserDTO;
import com.photo.photogram.Handler.ex.CustomValidationException;
import com.photo.photogram.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.URI;
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

//    @PostMapping("/login.json")
//    public ResponseEntity<Object> login(@RequestBody UserDTO userDTO, BindingResult bindingResult, HttpServletRequest request) throws Exception {
//        if (bindingResult.hasErrors()) {
//            Map<String, String> errorMap = new HashMap<>();
//
//            for (FieldError error : bindingResult.getFieldErrors()) {
//                errorMap.put(error.getField(), error.getDefaultMessage());
//            }
//            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
//        } else {
//            try {
//                HttpSession session = request.getSession();
//                UserDTO result = userService.login(userDTO);
//                session.setAttribute("userInfo", result);
//                return new ResponseEntity<>("result : OK", HttpStatus.OK);
//            } catch (Exception e) {
//                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//            }
//        }
//    }

    @GetMapping("/signup")
    public String signUp() throws Exception{
        logger.info(url+"/signup Call");
        return url+"/signup";
    }

    @PostMapping("/signup.json")
    public ResponseEntity<Object> signUpJson(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new CustomValidationException("result : 유효성 검사 실패", errorMap);
        } else {
            try {
                userService.signup(userDTO);
                return new ResponseEntity<>("result : OK" , HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("result : " + e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
    }

}
