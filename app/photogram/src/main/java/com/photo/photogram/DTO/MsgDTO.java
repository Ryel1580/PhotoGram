package com.photo.photogram.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MsgDTO {
    int roomId;
    int sndId;
    String sndNm;
    String msg;
    Date rgsDate;
    String rgsUsr;

}
