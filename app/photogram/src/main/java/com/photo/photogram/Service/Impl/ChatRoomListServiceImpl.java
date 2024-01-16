package com.photo.photogram.Service.Impl;

import com.photo.photogram.DAO.ChatRoomListDAO;
import com.photo.photogram.DTO.ChatRoomListDTO;
import com.photo.photogram.DTO.EnterChatRoomDTO;
import com.photo.photogram.DTO.UserDTO;
import com.photo.photogram.Service.ChatRoomListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatRoomListServiceImpl implements ChatRoomListService {

    @Autowired
    ChatRoomListDAO chatRoomListDAO;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ChatRoomListDTO chatList(int id){
      return chatRoomListDAO.chatList(id);
    }

    @Override
    public List<UserDTO> getUser(int id){
        return chatRoomListDAO.getUser(id);
    }

    public void getRoomNum(EnterChatRoomDTO enterChatRoomDTO){
        List<EnterChatRoomDTO> getRoomList = chatRoomListDAO.getRoomNum(enterChatRoomDTO);

        if(getRoomList.isEmpty()){
            chatRoomListDAO.insertRoomNum(enterChatRoomDTO);
        }
    }
}
