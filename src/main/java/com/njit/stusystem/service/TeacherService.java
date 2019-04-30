package com.njit.stusystem.service;

import com.njit.stusystem.dto.*;
import com.njit.stusystem.mapper.CourseMapper;
import com.njit.stusystem.mapper.MessageMapper;
import com.njit.stusystem.mapper.TeacherMapper;
import com.njit.stusystem.model.Course;
import com.njit.stusystem.model.Message;
import com.njit.stusystem.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private MessageMapper messageMapper;

    /**可选择的修改学生成绩*/
    public int updateStuCourse(Course record)
    {
        return courseMapper.updateByPrimaryKeySelective( record);
    }

    /*得到本班学生课程对应的学号和学年*/
    public List<StuCourseOfYearDTO> selectStuIdAndYearByTeacherId( Integer id)
    {
        return courseMapper.selectStuIdAndYearByTeacherId(id);
    }

    /*得到本班学生个人课程对应的学号和学年*/
    public List<StuCourseOfYearDTO> selectStuIdAndYearByStuId(Integer studentId)
    {
        return courseMapper.selectStuIdAndYearByStuId(studentId);
    }

    /*删除学生成绩*/
    public int deleteStuAndCourse(Integer id)
    {
        return courseMapper.deleteByPrimaryKey(id);
    }

    /*可选择的添加成绩表*/
    public int insertCourse(Course record)
    {
        return courseMapper.insertSelective(record);
    }

    /*查询班主任本班学生的成绩*/
    public List<StuAndCourseDTO> selectCourseByYears(Integer year,Integer id)
    {
        return courseMapper.selectCourseByYears(year,id);
    }

    /*统计各个分段学生成绩*/
    public List Statistics(Integer year,Integer id)
    {
        CourseDTO courseDTO=new CourseDTO();
        List list=new ArrayList();
        courseDTO.setGrade("差(总分小于320分)").setNumbers(courseMapper.selectCount(0,320,year,id));

        CourseDTO courseDTO2=new CourseDTO();
        courseDTO2.setGrade("较差").setNumbers(courseMapper.selectCount(320,420,year,id));

        CourseDTO courseDTO3=new CourseDTO();
        courseDTO3.setGrade("中等").setNumbers(courseMapper.selectCount(420,500,year,id));

        CourseDTO courseDTO4=new CourseDTO();
        courseDTO4.setGrade("良好").setNumbers(courseMapper.selectCount(500,620,year,id));

        CourseDTO courseDTO5=new CourseDTO();
        courseDTO5.setGrade("优秀").setNumbers(courseMapper.selectCount(620,750,year,id));

        list.add(courseDTO);
        list.add(courseDTO2);
        list.add(courseDTO3);
        list.add(courseDTO4);
        list.add(courseDTO5);
        return list;

    }

    /*根据学生id和学生姓名，教师ID，查询该学生每学年度的总分*/
    public List selectStuCourse(Integer teacherId,Integer stuId,String name)
    {
        List<Integer> list=courseMapper.selectCourseByYear(teacherId,stuId,name);
        List list2=new ArrayList();
        System.out.println(list);
        for (int i=0;i<list.size();i++)
        {

            list2.add(new CourseAndYearsDTO().setSchoolYear("第"+(i+1)+"学期").setTotalScore(list.get(i)));

        }
        return list2;
    }

    /*多选删除学生成绩*/
    public int deleteStuAndCourseByCheck(Integer id)
    {
        return courseMapper.deleteByPrimaryKey(id);
    }

    /*登录验证用户名和密码，用户名为主键id*/
    public TeacherDTO selectByUsernameAndPassword(Integer id,String password)
    {
        return teacherMapper.selectByUsernameAndPassword(id, password);
    }

    public UnReadCountsDTO getUnReadCount(Integer id)
    {
        return messageMapper.selectUnReadCounts(id);
    }

    /** 根据教师id查询该教师收到的信息*/
    public Map<String,List> selectMessageByTeacherId(Integer id)
    {
        messageMapper.updateStatusByUserId(id);
        Map<String,List> map=new HashMap();
        List<MessageDTO> notificationList=messageMapper.selectByTeacherId(id,"notification");
        map.put("notices",notificationList);
        return map;
    }

    /** 根据教师id向全班学生发送班级信息*/
    public void sendMessageToStu(String message,Integer id)
    {
        for (int i:teacherMapper.selectStuIdByTeacherId(id)
             ) {
            Message record=new Message();
            record.setAvatar("https://gw.alipayobjects.com/zos/rmsportal/ThXAXghbEsBCCSDihZxY.png")
                    .setTitle(message).setType("message").setUserId(i).
                    setDatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            messageMapper.insertSelective(record);
        }
    }

    /*根据教师姓名查询教师信息*/
    public TeacherDTO selectByName(String name)
    {
        return teacherMapper.selectByName(name);
    }

    /*查询教师表所有信息*/
    public List<TeacherDTO> selectAll()
    {
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd");
        List<Teacher> teachers = teacherMapper.selectAll();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();

        teachers.stream().forEach(t->{
            TeacherDTO teacherDTO = new TeacherDTO();
            try {
                teacherDTO.setId(t.getId());
                teacherDTO.setTeacherName(t.getTeacherName());
                teacherDTO.setTeacherPassword(t.getTeacherPassword());
                if(t.getTeacherAddress()!=null)
                {
                    teacherDTO.setTeacherAddress(t.getTeacherAddress());
                }
                if(t.getTeacherPhone()!=null)
                {
                    teacherDTO.setTeacherPhone(t.getTeacherPhone());
                }
                if(t.getTeacherSex()!=null)
                {
                    teacherDTO.setTeacherSex(t.getTeacherSex());
                }
                if(t.getTeacherEmail()!=null)
                {
                    teacherDTO.setTeacherEmail(t.getTeacherEmail());
                }
                if(t.getTeacherBrithday()!=null)
                {
                    teacherDTO.setTeacherBrithday(temp.format(t.getTeacherBrithday()));
                }

                teacherDTOList.add(teacherDTO);
            }
            catch (NullPointerException e)
            {
                e.printStackTrace();
            }

        });
        return teacherDTOList;
    }

    /*根据教师id查询教师信息*/
    public TeacherDTO selectById(Integer id){
        return teacherMapper.selectById(id);
    }

    /*根据教师id删除教师信息*/
    public int deleteByPrimaryKey(Integer id)
    {
        return teacherMapper.deleteByPrimaryKey(id);
    }

    /*根据教师id修改教师信息*/
    public int updateByPrimaryKeySelective(Teacher teacher)
    {
        return teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    /*根据教师email查询教师信息,ps:用于忘记密码时判断邮箱是否存在，存在返回教师信息，不存在返回null*/
    public TeacherDTO selectEmail(String email)
    {
        return teacherMapper.selectEmail(email);
    }

    /*新增教师信息*/
    public int insertSelective(Teacher record){
        return teacherMapper.insertSelective(record);
    }
}
