package com.photo.photogram.Service.Impl;

import com.photo.photogram.DAO.ChatDAO;
import com.photo.photogram.DTO.MsgDTO;
import com.photo.photogram.Service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatDAO chatDAO;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public MsgDTO getMsgAll(MsgDTO msgDTO){
        logger.info("====================RcvData====================");
        logger.info(String.valueOf(msgDTO.getRoomId()));
        logger.info(String.valueOf(msgDTO.getSndId()));
        logger.info(msgDTO.getSndNm());
        logger.info(msgDTO.getMsg());
        logger.info(String.valueOf(msgDTO.getRgsDate()));
        logger.info(msgDTO.getRgsUsr());
        logger.info("===============================================");

        MsgDTO result = chatDAO.sndMsg(msgDTO);

        if (result != null){
            logger.info("==========Result Data==========");
            logger.info(String.valueOf(msgDTO.getRoomId()));
            logger.info(String.valueOf(msgDTO.getSndId()));
            logger.info(msgDTO.getSndNm());
            logger.info(msgDTO.getMsg());
            logger.info(String.valueOf(msgDTO.getRgsDate()));
            logger.info(msgDTO.getRgsUsr());
            logger.info("===============================");
            return result;
        }
        else {
            logger.info("==========Result Data: Login Failed==========");
            return null;
        }
    }


    public void senMsg(MsgDTO msgDTO){
        logger.info("====================RcvData====================");
        logger.info(String.valueOf(msgDTO.getRoomId()));
        logger.info(String.valueOf(msgDTO.getSndId()));
        logger.info(msgDTO.getSndNm());
        logger.info(msgDTO.getMsg());
        logger.info(String.valueOf(msgDTO.getRgsDate()));
        logger.info(msgDTO.getRgsUsr());
        logger.info("===============================================");
    }
}
