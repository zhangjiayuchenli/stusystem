package com.njit.stusystem.service;

import com.njit.stusystem.dto.*;
import com.njit.stusystem.mapper.CourseMapper;
import com.njit.stusystem.mapper.MessageMapper;
import com.njit.stusystem.mapper.StudentMapper;
import com.njit.stusystem.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private MessageMapper messageMapper;
    /*根据学生id和学年获取学生成绩等信息*/
    public StuAndCourseDTO selectCourseByStuIdAndYear( Integer id, Integer year)
    {
        return courseMapper.selectCourseByStuIdAndYear(id,year);
    }

    /*登录验证用户名和密码，用户名为主键id*/
    public StudentDTO selectByUsernameAndPassword(Integer id,String password)
    {
        return studentMapper.selectByUsernameAndPassword(id, password);
    }

    /**根据学生id和学生姓名，教师ID，查询该学生每学年度的总分*/
    public List selectCourseByStuId(Integer stuId)
    {
        List<Integer> list=courseMapper.selectCourseByStuId(stuId);
        List list2=new ArrayList();
        System.out.println(list);
        for (int i=0;i<list.size();i++)
        {

            list2.add(new CourseAndYearsDTO().setSchoolYear("第"+(i+1)+"学期").setTotalScore(list.get(i)));

        }
        return list2;
    }

    /**根据学生id查询消息*/
    public List<MessageDTO> selectMessageByStuId(Integer id)
    {
        messageMapper.updateStatusByUserId(id);
        return messageMapper.selectByStuId(id,"notification");
    }

    /**根据学生id查询消息*/
    public Map<String,List> selectMessageByStuId2(Integer id)
    {
        messageMapper.updateStatusByUserId(id);
        List<MessageDTO> notificationList=messageMapper.selectByStuId(id,"notification");
        List<MessageDTO> messageList=messageMapper.selectByStuId(id,"message");
        Map<String,List> map=new HashMap();
        map.put("notices",notificationList);
        map.put("message",messageList);
        return map;
    }
    //根据学生id查询该教师未读消息
    public UnReadCountsDTO selectUnReadCountsByStuId( Integer id)
    {
        return messageMapper.selectUnReadCountsByStuId(id);
    }

    /*查询所有学生信息*/
    public List<TeaAndStuDTO> selectAll()
    {
        return studentMapper.selectAll();
    }

    /*新增学生*/
    public int insertSelective(Student record)
    {
        return studentMapper.insertSelective(record);
    }

    /*修改学生信息*/
    public int updateByPrimaryKeySelective(Student record)
    {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    /*根据学生id删除学生*/
    public int deleteByPrimaryKey(Integer id){
        return studentMapper.deleteByPrimaryKey(id);
    }

    /*根据学生email查询学生信息,ps:用于忘记密码时判断邮箱是否存在，存在返回学生信息，不存在返回null*/
    public StudentDTO selectByEmail(String email)
    {
        return studentMapper.selectByEmail(email);
    }
}
