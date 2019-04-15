package com.njit.stusystem.service;

import com.njit.stusystem.dto.AdminDTO;
import com.njit.stusystem.mapper.AdminMapper;
import com.njit.stusystem.mapper.MessageMapper;
import com.njit.stusystem.mapper.StudentMapper;
import com.njit.stusystem.mapper.TeacherMapper;
import com.njit.stusystem.model.Admin;
import com.njit.stusystem.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentMapper studentMapper;

    /*根据主键删除管理员*/
    public int deleteByPrimaryKey(Integer id)
    {
        return adminMapper.deleteByPrimaryKey(id);
    }

    /*登录验证用户名和密码，用户名为主键id*/
    public AdminDTO selectByUsernameAndPassword(Integer id, String password)
    {
        return adminMapper.selectByUsernameAndPassword(id,password);
    }

    /*修改管理员信息*/
    public int updateByPrimaryKey(Admin record)
    {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    /*向所有教师发送消息*/
    public void sendMessageToTeacher(String message)
    {
        for (int i:teacherMapper.selectId()
        ) {
            Message record=new Message();
            record.setAvatar("https://gw.alipayobjects.com/zos/rmsportal/ThXAXghbEsBCCSDihZxY.png")
                    .setTitle(message).setType("notification").setUserId(i).
                    setDatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            messageMapper.insertSelective(record);
        }
    }
    /*向所有学生发送消息*/
    public void sendMessageToStu(String message)
    {
        for (int i:studentMapper.selectId()
        ) {
            Message record=new Message();
            record.setAvatar("https://gw.alipayobjects.com/zos/rmsportal/ThXAXghbEsBCCSDihZxY.png")
                    .setTitle(message).setType("notification").setUserId(i).
                    setDatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            messageMapper.insertSelective(record);
        }
    }
    /*向所有教师和学生发送消息*/
    public void sendMessageToAll(String message)
    {
        sendMessageToTeacher(message);
        sendMessageToStu(message);
    }
}
