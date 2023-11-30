package com.photo.photogram.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    int roomId;
    String roomNm;
    int roomNum;
    int roomMaxNum;
    char useAt;
    Date rgsdate;
    String rgsUsr;
    Date modDate;
    String modUsr;
}
