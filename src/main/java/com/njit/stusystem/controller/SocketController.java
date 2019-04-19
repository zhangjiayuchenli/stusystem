package com.njit.stusystem.controller;

import com.njit.stusystem.dto.MessageDTO;
import com.njit.stusystem.dto.Result;
import com.njit.stusystem.dto.UnReadCountsDTO;
import com.njit.stusystem.service.StudentService;
import com.njit.stusystem.service.TeacherService;
import com.njit.stusystem.socket.MyWebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author ZJY
 * @version 1.0
 * @date 2019/4/15 17:38
 */
@RestController
@RequestMapping("/socket/")
public class SocketController {


    @Autowired
    private MyWebSocket myWebSocket;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    String teacher="teacher";
    String stu="stu";
    /**根据id获取消息*/
    @GetMapping("notices")
    public Result  getMessage(HttpSession session)
    {
        int id=(Integer) session.getAttribute("id");
        String type=(String) session.getAttribute("type");
        if (teacher.equals(type))
        {
            Map map=teacherService.selectMessageByTeacherId(id);
            return Result.<Map>builder().res(map).build();
        }
        if (stu.equals(type))
        {
            Map map=studentService.selectMessageByStuId(id);
            return Result.<Map>builder().res(map).build();
        }
        return Result.<List<MessageDTO>>builder().code(Result.FAILED_CODE).build();
    }
    /**根据id获取未读消息数量*/
    @GetMapping("getUnReadCount")
    public Result getUnReadCount(HttpSession session)
    {
        int id=(Integer) session.getAttribute("id");
        String type=(String) session.getAttribute("type");
        if (teacher.equals(type))
        {
            UnReadCountsDTO list=teacherService.getUnReadCount(id);
            return Result.<UnReadCountsDTO>builder().res(list).build();
        }
        if (stu.equals(type))
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
