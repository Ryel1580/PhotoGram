package com.photo.photogram.DAO;


import com.photo.photogram.DTO.ChatRoomListDTO;
import com.photo.photogram.DTO.EnterChatRoomDTO;
import com.photo.photogram.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ChatRoomListDAO {
    ChatRoomListDTO chatList(int id);
    List<UserDTO> getUser(int id);

    List<EnterChatRoomDTO> getRoomNum(EnterChatRoomDTO enterChatRoomDTO);

    void insertRoomNum(EnterChatRoomDTO enterChatRoomDTO);

}
