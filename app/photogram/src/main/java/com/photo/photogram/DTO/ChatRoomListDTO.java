package com.photo.photogram.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomListDTO {
    int roomId;
    String roomNm;
    int roomNum;
    int RoomMaxNum;
    char useAt;
    Date rgsDate;
    String rgsUsr;
    Date modDate;
    String modUsr;
}
