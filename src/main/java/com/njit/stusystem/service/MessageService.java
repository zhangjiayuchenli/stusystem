package com.njit.stusystem.service;

import com.njit.stusystem.mapper.MessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    public int clearNoticesByIdAndType(Integer id,String type)
    {
        return messageMapper.clearNoticesByIdAndType(id,type);
    }
}
