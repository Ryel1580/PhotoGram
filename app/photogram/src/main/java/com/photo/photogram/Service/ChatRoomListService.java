package com.photo.photogram.Service;

import com.photo.photogram.DTO.ChatRoomListDTO;
import org.springframework.stereotype.Service;

@Service
public interface ChatRoomListService {
    ChatRoomListDTO chatList(int id);

//    int getUser(int id);

}
