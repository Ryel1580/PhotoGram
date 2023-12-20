package com.photo.photogram.Controller;

import com.photo.photogram.Config.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/user/{id}")
    public String profile(@PathVariable int id){
        return "user/profile";
    }

    @GetMapping("/user/{id}/update")
    public String update(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails){
        logger.info("userData : " + principalDetails.getUserDTO());
        // <sec:authorize access ="isAuthenticated()">
        //    <sec:authentication property="principal" var ="userInfo"/>
        //</sec:authorize>
        // 시큐리티 테그 사용해서 넘길 수 있다.

        return "user/update";
    }
}
