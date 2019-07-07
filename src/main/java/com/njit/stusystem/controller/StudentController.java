package com.njit.stusystem.controller;

import com.njit.stusystem.dto.*;
import com.njit.stusystem.mapper.TeacherMapper;
import com.njit.stusystem.model.Student;
import com.njit.stusystem.service.StudentService;
import com.njit.stusystem.utils.MD5Util;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/**
 * @author ZJY
 * @version 1.0
 * @date 2019/4/15 17:38
 */
@RestController
@RequestMapping("student/")
@Api("相关api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherMapper teacherMapper;
    /**查询所有学生信息*/
    @GetMapping("selectAll")
    public Result<List<TeaAndStuDTO>> selectAll()
    {
        List<TeaAndStuDTO> list=studentService.selectAll();
        return Result.<List<TeaAndStuDTO>>builder().res(list).build();
    }

    /**上传头像*/
    @PostMapping("uploadAvatar")
    public Result uploadPic(@RequestParam(value="file") MultipartFile file, HttpSession session){
        //得到上传时的原始文件名
        System.out.println(file.getOriginalFilename());
        //生成随机图片名
        String fileName = UUID.randomUUID().toString().substring(24)+".png";
        //指定图片存放地址
        Student student=new Student();
        String path = "D:/daily/upload/image" ;
        File dest = new File(path + "/" + fileName);
        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            //父目录不存在则新建文件
            dest.getParentFile().mkdir();
        }
        System.out.println("绝对路径:"+dest);
        try {
            //将文件保存到本地
            file.transferTo(dest);
            student.setId((Integer) session.getAttribute("id"));
            student.setStudentAvatar("http://localhost:8080/image/"+fileName);
            studentService.updateByPrimaryKeySelective(student);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return Result.builder().code(Result.SUCCESS_CODE).res("http://localhost:8080/image/"+fileName).build();
    }

    /**学生根据学年获得每学期各科成绩*/
    @GetMapping("selectCourseByYears")
    public Result selectCourseByYears(Integer year, HttpSession session)
    {
        int id=(Integer)session.getAttribute("id");
        List<StuAndCourseDTO> list=new ArrayList<>();
        list.add(studentService.selectCourseByStuIdAndYear(id,year));
        return Result.<List<StuAndCourseDTO>>builder().res(list).build();
    }

    /**修改学生信息*/
    @PutMapping("updateStu")
    public Result<List<TeaAndStuDTO>> updateStu(@RequestBody Student student,HttpSession session){
        student.setId((Integer)session.getAttribute("id"));
        student.setStudentPassword(MD5Util.MD5(student.getStudentPassword()));
        if(student.getTeacherId()!=null)
        {
            student.setTeacherId(student.getTeacherId());
        }
        studentService.updateByPrimaryKeySelective(student);
        List<TeaAndStuDTO> list=studentService.selectAll();
        return Result.<List<TeaAndStuDTO>>builder().res(list).build();
    }

    /**学生修改个人密码*/
    @PutMapping("updateStuPassword")
    public Result updateStuPassword(@RequestBody Map<String,String> map,HttpSession session)
    {
        Student student=new Student();
        int id=(Integer)session.getAttribute("id");
        StudentDTO studentDTO=studentService.selectById(id);
        if(studentDTO.getStudentPassword().equals(MD5Util.MD5(map.get("password"))))
        {
            student.setId(id);
            student.setStudentPassword(MD5Util.MD5(map.get("studentPassword")));
            studentService.updateByPrimaryKeySelective(student);
            return Result.builder().code(Result.SUCCESS_CODE).build();

        }
        return Result.builder().code(Result.FAILED_CODE).build();
    }

    @PutMapping("adminUpdateStu")
    public Result<List<TeaAndStuDTO>> adminUpdateStu(@RequestBody StudentDTOO studentDTO){

        int teacherId=teacherMapper.selectTeacherIdByClassName(studentDTO.getClassName());

        Student student = studentDTO.getStudent();
        student.setTeacherId(teacherId);
        studentService.updateByPrimaryKeySelective(student);
        List<TeaAndStuDTO> list=studentService.selectAll();
        return Result.<List<TeaAndStuDTO>>builder().res(list).build();
    }

    /**根据学生学号获得学生每学期的成绩总分(用来可视化分析-折线图)*/
    @GetMapping("selectCourseByStuId")
    public Result<List<CourseAndYearsDTO>> selectCourseByStuId(HttpSession session)
    {
        List<CourseAndYearsDTO> list=studentService.selectCourseByStuId((Integer)session.getAttribute("id"));
        return Result.<List<CourseAndYearsDTO>>builder().res(list).build();
    }

    /**新增学生信息*/
    @PostMapping("insertStu")
    public Result<List<TeaAndStuDTO>> insertStu(@RequestBody Student student)
    {
        studentService.insertSelective(student);
        List<TeaAndStuDTO> list=studentService.selectAll();
        return Result.<List<TeaAndStuDTO>>builder().res(list).build();

    }

    /**删除学生信息*/
    @DeleteMapping("deleteStu")
    public Result<List<TeaAndStuDTO>> deleteStu(@RequestBody Map<String,String> map)
    {
        studentService.deleteByPrimaryKey(Integer.parseInt(map.get("id")));
        List<TeaAndStuDTO> list=studentService.selectAll();
        return Result.<List<TeaAndStuDTO>>builder().res(list).build();
    }

    /**多选删除学生信息*/
    @DeleteMapping("deleteStuByCheck")
    public Result<List<TeaAndStuDTO>> deleteStuByCheck(@RequestBody Map<String,List> map)
    {
        ((List<Integer>)map.get("list")).stream().forEach(t->{
            studentService.deleteByPrimaryKey(t);
        });
        List<TeaAndStuDTO> list=studentService.selectAll();
        return Result.<List<TeaAndStuDTO>>builder().code(Result.SUCCESS_CODE).res(list).build();
    }



}
