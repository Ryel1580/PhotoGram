package com.photo.photogram.Config;




import com.photo.photogram.Handler.ChatHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig  implements WebSocketConfigurer {

    private final ChatHandler chatHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatHandler, "ws/chat")
                .setAllowedOrigins("http://localhost:8080")
        ;
    }
}

//핸들러를 이용해 WebSocket을 활성화하기 위한 Config를 작성할 것이다.
//@EnableWebSocket 어노테이션을 사용해 WebSocket을 활성화 하도록 한다.
//WebSocket에 접속하기 위한 Endpoint는 /chat으로 설정하고,
//도메인이 다른 서버에서도 접속 가능하도록 CORS : setAllowedOrigins("*"); 를 추가해준다.
// 이제 클라이언트가 ws://localhost:8080/chat으로 커넥션을 연결하고 메세지 통신을 할 수 있는 준비를 마쳤다.