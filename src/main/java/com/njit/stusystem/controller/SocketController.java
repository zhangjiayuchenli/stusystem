package com.njit.stusystem.controller;

import com.njit.stusystem.dto.MessageDTO;
import com.njit.stusystem.dto.Result;
import com.njit.stusystem.dto.UnReadCountsDTO;
import com.njit.stusystem.dto.chatDTO;
import com.njit.stusystem.service.StudentService;
import com.njit.stusystem.service.TeacherService;
import com.njit.stusystem.socket.MyWebSocket;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/socket/")
public class SocketController {


    @Autowired
    private MyWebSocket myWebSocket;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    /*根据id获取消息*/
    @GetMapping("notices")
    public Result  getMessage(Integer id,String type)
    {
        if (type.equals("b"))
        {
            List<MessageDTO> list=teacherService.selectMessageByTeacherId(id);
            return Result.<List<MessageDTO>>builder().res(list).build();
        }
        if (type.equals("c"))
        {
            List<MessageDTO> list=studentService.selectMessageByStuId(id);
            return Result.<List<MessageDTO>>builder().res(list).build();
        }
        return Result.<List<MessageDTO>>builder().code(Result.FAILED_CODE).build();
    }
    /*根据id获取未读消息数量*/
    @GetMapping("getUnReadCount")
    public Result getUnReadCount(Integer id,String type)
    {
        if (type.equals("teacher"))
        {
            UnReadCountsDTO list=teacherService.getUnReadCount(id);
            return Result.<UnReadCountsDTO>builder().res(list).build();
        }
        if (type.equals("stu"))
        {
            UnReadCountsDTO list=studentService.selectUnReadCountsByStuId(id);
            return Result.<UnReadCountsDTO>builder().res(list).build();
        }

        return Result.<UnReadCountsDTO>builder().code(Result.FAILED_CODE).build();
    }
/*
    @PostMapping("admin/sendMessage")
    public Result SendMessage(@RequestBody Map<String,String> map)
    {
        chatDTO chatDTO=new chatDTO();
        chatDTO.setDescription(map.get("description"));
        try {
            MyWebSocket.sendInfo(chatDTO.getDescription(),"2");
            //WebSocketServer.sendInfo(JSONObject.toJSONString(chatDto), chat.getToUserId())
        }catch(Exception e){
            e.printStackTrace();
        }

        return Result.builder().code(Result.SUCCESS_CODE).build();
    }*/

}
