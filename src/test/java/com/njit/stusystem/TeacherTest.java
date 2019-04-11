package com.njit.stusystem;

import com.njit.stusystem.mapper.TeacherMapper;
import com.njit.stusystem.model.Teacher;
import com.njit.stusystem.service.TeacherService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TeacherTest extends BaseTest {
    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherService teacherService;

    @Test
    public void testDelete()
    {
        teacherMapper.selectByPrimaryKey(26);
    }

    @Test
    public void testSelest()
    {

    }

    @Test
    public void testInsert() throws ParseException
    {
        Teacher teacher=new Teacher();


        for (int i = 0; i < 50; i++) {
            Date date=new Date();   //这里的时util包下的
            SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd");  //这是24时
            teacher.setTeacherName(RandomValue.getChineseName());
            teacher.setTeacherPassword("123456");
            teacher.setTeacherSex("男");
            teacher.setTeacherBrithday(temp.parse(temp.format(date)));
            teacher.setTeacherAddress(RandomValue.getRoad());
            teacher.setTeacherEmail(RandomValue.getEmail(1,9));
            teacher.setTeacherPhone(RandomValue.getTel());
            teacherMapper.insertSelective(teacher);
        }

    }
    @Test
    public void testUpdate() throws ParseException
    {
        Teacher teacher=new Teacher();
        Date date=new Date();
        String s="2016-10-24 21:59:06";//这里的时util包下的
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd");
        teacher.setTeacherBrithday(temp.parse(s));
        teacher.setId(80);
        teacherMapper.updateByPrimaryKeySelective(teacher);
    }


}
