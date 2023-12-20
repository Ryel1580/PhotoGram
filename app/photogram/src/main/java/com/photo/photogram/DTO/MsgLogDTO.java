package com.photo.photogram.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MsgLogDTO {
    int roomId;
    String roomNm;
    String msg;
    Date rgsDate;
    String rgsUsr;
    Date modDate;
    String modUsr;

}
