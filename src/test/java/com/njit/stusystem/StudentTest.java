package com.njit.stusystem;

import com.njit.stusystem.dto.StudentDTO;
import com.njit.stusystem.mapper.StudentMapper;
import com.njit.stusystem.model.Student;
import com.njit.stusystem.service.StudentService;
import com.njit.stusystem.utils.MD5Util;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentTest extends BaseTest {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentService studentService;

    @Test
    public void testInsert()
    {
        Student student=new Student();
        for (int i=0;i<3;i++) {
            Date date = new Date();
            SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd");
            student.setStudentName(RandomValue.getChineseName());
            student.setStudentPassword(MD5Util.MD5("123"));
            student.setStudentBirthday(temp.format(date));
            student.setStudentPhone(RandomValue.getTel());
            student.setStudentAddress(RandomValue.getRoad());
            student.setStudentEmail(RandomValue.getEmail(1,9));
            student.setTeacherId(6);
            studentMapper.insertSelective(student);
        }
    }

    @Test
    public void display()
    {
        StudentDTO studentDTO=studentService.selectByUsernameAndPassword(202151336,"11");
        System.out.println(studentDTO.getStudentName());
    }

    @Test
    public void selectById()
    {
        StudentDTO studentDTO=studentService.selectById(202151336);
        System.out.println(studentDTO.toString());
    }
}
