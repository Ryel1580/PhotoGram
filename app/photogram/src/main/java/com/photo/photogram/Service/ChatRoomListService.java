package com.photo.photogram.Service;

import com.photo.photogram.DTO.ChatRoomListDTO;
import com.photo.photogram.DTO.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatRoomListService {
    ChatRoomListDTO chatList(int id);

    List<UserDTO> getUser(int id);

}
