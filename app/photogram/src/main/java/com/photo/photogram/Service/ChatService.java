package com.photo.photogram.Service;

import com.photo.photogram.DTO.MsgDTO;
import org.springframework.stereotype.Service;

@Service
public interface ChatService {
    MsgDTO getMsgAll (MsgDTO msgDTO);

    void senMsg(MsgDTO msgDTO);
}
