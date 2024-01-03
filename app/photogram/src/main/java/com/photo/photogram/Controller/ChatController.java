package com.photo.photogram.Controller;

import com.photo.photogram.DTO.MsgDTO;
import com.photo.photogram.Service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Controller //파일을 응답하는 컨트롤러
@RequestMapping(value = "/chat")
@ServerEndpoint("/websocket")
public class ChatController extends Socket {
    @Autowired
    ChatService chatService;
    private static final List<Session> session = new ArrayList<Session>();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String msg(){
        return "chat/chatRoomList";
    }

    @GetMapping("/chat")
    public String openChat(){
        return "chat/chat";
    }
    @GetMapping("/getMsgAll")
    public ResponseEntity<String> getMsgAll(@RequestBody MsgDTO msgDTO)throws Exception{
        logger.info(String.valueOf(msgDTO));
        try{
            MsgDTO result = chatService.getMsgAll(msgDTO);
            logger.info(String.valueOf(result));
            return new ResponseEntity<>("result :" +result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("result : " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/chat.json")
    public ResponseEntity<String> senMsg(@RequestBody MsgDTO msgDTO) throws Exception{
        logger.info(String.valueOf(msgDTO));

        try{
            chatService.senMsg(msgDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("result : " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
