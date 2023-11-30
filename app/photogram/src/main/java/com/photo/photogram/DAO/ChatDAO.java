package com.photo.photogram.DAO;

import com.photo.photogram.DTO.MsgDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ChatDAO {

    MsgDTO getMsgAll(MsgDTO msgDTO);
    MsgDTO sndMsg(MsgDTO msgDTO);
}
