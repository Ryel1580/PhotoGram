package com.photo.photogram.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterChatRoomDTO {
    int sndId;
    int rcvId;
    Date rgsDate;
}
