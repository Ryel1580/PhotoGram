package com.photo.photogram.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


@EnableWebSecurity // 해당 파일로 시큐리티 활성화
@Configuration // ioc
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    // 비밀번호 암호화 인코더
    @Bean
    public BCryptPasswordEncoder encode(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super 삭제 - 기존 시큐리티 기능비활성화
        http.csrf().disable(); //csrf 는 정상적인 방법과(홈페이지에서 가입) 비정상적인 방법(postman 등 사용해서) 하는방법을 구분하기 위해
        //csrf 토큰을 발행함. 일단 비활성화
        http.authorizeRequests()
                    .antMatchers( "/","/image/**", "/subscribe/**", "/comment/**").authenticated() // 해당 주소들만 인증이 필요하도록 설정
                    .anyRequest().permitAll() // 위에 주소를 제외하고 모든 인증 허용
                    .and()
                .formLogin()
                    .loginPage("/auth/signin") // 로그인 페이지 주소 GET
                    .loginProcessingUrl("/auth/login.json") // 로그인 프로세스 POST
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/auth/signin")
                    .invalidateHttpSession(true) // 세션 날리기
                    .permitAll();
    }

}
