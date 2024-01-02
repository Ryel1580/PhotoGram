package com.photo.photogram.DAO;


import com.photo.photogram.DTO.ChatRoomListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ChatRoomListDAO {
    ChatRoomListDTO chatList(int id);

//    int getUser(int id);
}
