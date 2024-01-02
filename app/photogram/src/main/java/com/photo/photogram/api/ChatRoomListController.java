package com.photo.photogram.api;

import com.photo.photogram.DTO.ChatRoomListDTO;
import com.photo.photogram.Service.ChatRoomListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChatRoomListController {

    @Autowired
    ChatRoomListService chatRoomListService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping("/api/chatList/{id}")
    public ResponseEntity<ChatRoomListDTO> chatList(@PathVariable int id){
        logger.info(String.valueOf(id));
        ChatRoomListDTO chatRoomListDTO = chatRoomListService.chatList(id);
        return new ResponseEntity<>(chatRoomListDTO, HttpStatus.OK);
    }

//    @GetMapping("/api/getUser/{id}")
//    public ResponseEntity<Map<String,String>> getUser(@PathVariable int id){
//        logger.info(String.valueOf(id));
//        chatRoomListService.getUser(id);
//        return null;
//    }
}
