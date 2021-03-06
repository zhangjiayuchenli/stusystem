package com.njit.stusystem.controller;

import com.njit.stusystem.dto.*;
import com.njit.stusystem.model.Course;
import com.njit.stusystem.model.Teacher;
import com.njit.stusystem.service.TeacherService;
import com.njit.stusystem.utils.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.njit.stusystem.dto.Result.*;
/**
 * @author ZJY
 * @version 1.0
 * @date 2019/4/15 17:38
 */
@Slf4j
@RestController
@RequestMapping("teacher/")
@Api("相关api")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /*查询教师表所有信息*/
    @GetMapping("selectAll")
    public Result<List<TeacherDTO>> selectAll()
    {
        List<TeacherDTO> list=teacherService.selectAll();
        return Result.<List<TeacherDTO>>builder().res(list).build();
    }

    /*上传头像*/
    @PostMapping("uploadAvatar")
    public Result uploadPic(@RequestParam(value="file") MultipartFile file, HttpSession session){
        //得到上传时的原始文件名
        System.out.println(file.getOriginalFilename());
        //生成随机图片名
        String fileName = UUID.randomUUID().toString().substring(24)+".png";
        //指定图片存放地址
        Teacher teacher=new Teacher();
        String path = "D:/daily/upload/image" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();//父目录不存在则新建文件
        }
        System.out.println("绝对路径:"+dest);
        try {
            //将文件保存到本地
            file.transferTo(dest);
            teacher.setId((Integer) session.getAttribute("id"));
            System.out.println((Integer) session.getAttribute("id"));
            teacher.setTeacherAvatar("http://localhost:8080/image/"+fileName);
            teacherService.updateByPrimaryKeySelective(teacher);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return Result.builder().code(Result.SUCCESS_CODE).res("http://localhost:8080/image/"+fileName).build();
    }

    /** 根据教师id向全班学生发送班级信息*/
    @PostMapping("sendMessage")
    public Result sendMessageToStu(@RequestBody Map<String,String> map,HttpSession session)
    {
        teacherService.sendMessageToStu(map.get("description"),(Integer) session.getAttribute("id"));
        return Result.builder().code(Result.SUCCESS_CODE).build();
    }

    //


    /**根据教师id查询教师信息*/
    @ApiOperation(value = "根据ID查询教师信息",notes = "用于测试接口")
    @ApiImplicitParam(name = "id", value = "教师ID", required = true, dataType = "int")
    @GetMapping(value = "selectById")
    public TeacherDTO selectById( Integer id)
    {
        return teacherService.selectById(id);
    }

    /**根据教师姓名查询教师信息*/
    @GetMapping("selectByName")
    public Result<TeacherDTO> selectByName(@RequestBody Map<String,List> map)
    {
        ((List<Integer>)map.get("list")).stream().forEach(t->{
            teacherService.deleteByPrimaryKey(t);
        });
        TeacherDTO list2=teacherService.selectByName("");
        return Result.<TeacherDTO>builder().code(SUCCESS_CODE).res(list2).build();
    }

    /**教师修改个人的密码,需要先验证旧密码是否正确*/
    @PutMapping("updateTeacherPassword")
    public Result  updateTeacherPassword(@RequestBody Map<String,String>map,HttpSession session) throws ParseException
    {
        Teacher teacher=new Teacher();
        int id=(Integer)session.getAttribute("id");
        TeacherDTO teacherDTO=teacherService.selectById(id);
        if (teacherDTO.getTeacherPassword().equals(MD5Util.MD5(map.get("password"))))
        {
            teacher.setId(id);
            teacher.setTeacherPassword(MD5Util.MD5(map.get("teacherPassword")));
            log.info(teacher.toString());
            teacherService.updateByPrimaryKeySelective(teacher);
            return Result.builder().code(Result.SUCCESS_CODE).build();
        }
        return Result.builder().code(Result.FAILED_CODE).build();
    }

    /**教师修改个人信息*/
    @PutMapping("updateTeacher")
    public Result updateTeacher(@RequestBody Teacher teacher,HttpSession session)
    {
        teacher.setId((Integer)session.getAttribute("id"));
        teacherService.updateByPrimaryKeySelective(teacher);
        return Result.builder().code(Result.SUCCESS_CODE).build();
    }

    /**管理员根据教师id修改教师信息*/
    @PutMapping("adminUpdateTeacher")
    public Result<List<TeacherDTO>>  adminUpdateTeacher(@RequestBody Teacher teacher)
    {
        teacherService.updateByPrimaryKeySelective(teacher);
        List<TeacherDTO> list=teacherService.selectAll();
        return Result.<List<TeacherDTO>>builder().res(list).build();
    }


    /**新增教师信息*/
    @PostMapping("insertTeacher")
    public Result<List<TeacherDTO>>  insertTeacher(@RequestBody Teacher teacher)
    {
        teacherService.insertSelective(teacher);
        List<TeacherDTO> list=teacherService.selectAll();
        return Result.<List<TeacherDTO>>builder().res(list).build();

    }

    /**删除学生成绩*/
    @DeleteMapping("deleteStuAndCourse")
    public Result<List<StuAndCourseDTO>> deleteStuAndCourse(@RequestBody Map<String,String> map)
    {
        teacherService.deleteStuAndCourse(Integer.parseInt(map.get("id")));
        List<StuAndCourseDTO> list=teacherService.selectCourseByYears(Integer.parseInt(map.get("schoolYear")),Integer.parseInt(map.get("teacherId")));
        return Result.<List<StuAndCourseDTO>>builder().code(SUCCESS_CODE).res(list).build();
    }

    /**根据教师id删除教师信息*/
    @DeleteMapping("deleteByPrimaryKey")
    public Result<List<TeacherDTO>> deleteByPrimaryKey(@RequestBody Map<String,String> map)
    {
        teacherService.deleteByPrimaryKey(Integer.parseInt(map.get("id")) );
        List<TeacherDTO> list=teacherService.selectAll();
        return Result.<List<TeacherDTO>>builder().code(SUCCESS_CODE).res(list).build();
    }

    /**根据教师id多选删除教师信息*/
    @DeleteMapping("deleteByPrimaryKeyAndCheck")
    public Result<List<TeacherDTO>> deleteByPrimaryKeyAndCheck(@RequestBody Map<String,List> map)
    {
        ((List<Integer>)map.get("list")).stream().forEach(t->{
            teacherService.deleteByPrimaryKey(t);
        });
        List<TeacherDTO> list2=teacherService.selectAll();
        return Result.<List<TeacherDTO>>builder().code(Result.SUCCESS_CODE).res(list2).build();
    }

    /**多选删除学生成绩*/
    @DeleteMapping("deleteStuAndCourseByCheck")
    public Result<List<StuAndCourseDTO>> deleteStuAndCourseByCheck(@RequestBody Map<String,List> map)
    {
        ((List<Integer>)map.get("list")).stream().forEach(t->{

            teacherService.deleteStuAndCourseByCheck(t);
        });
        int year=((List<Integer>)map.get("yearList")).get(0);
        int id=((List<Integer>)map.get("teacherIdList")).get(0);
        List<StuAndCourseDTO> list=teacherService.selectCourseByYears(year,id);
        return Result.<List<StuAndCourseDTO>>builder().res(list).build();
    }

    /**查询班主任本班学生的成绩*/
    @ApiOperation(value = "根据教师id查询学生成绩", notes="用于测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "教师ID",required = true, dataType = "int"),
            @ApiImplicitParam(name = "year", value = "学年",required = true, dataType = "int")
    })
    @GetMapping("selectCourseByYears")
    public Result<List<StuAndCourseDTO>> selectCourseByYears(Integer year,HttpSession session)
    {
        List<StuAndCourseDTO> list=teacherService.selectCourseByYears(year,(Integer)session.getAttribute("id"));
        return Result.<List<StuAndCourseDTO>>builder().res(list).build();

    }

    /**得到本班学生课程对应的学号和学年*/
    @GetMapping("selectStuIdAndYearByTeacherId")
    public Result<List<StuCourseOfYearDTO>> selectStuIdAndYearByTeacherId( HttpSession session)
    {
        List<StuCourseOfYearDTO> list=teacherService.selectStuIdAndYearByTeacherId((Integer)session.getAttribute("id"));
        return Result.<List<StuCourseOfYearDTO>>builder().res(list).build();
    }

    /**根据学生id或姓名，和教师id，查询该学生每学年度的总分 text为学号或者学生姓名*/
    @GetMapping("selectSumCourseByYear")
    public Result<List<CourseAndYearsDTO>> selectCourseByYear(String text,HttpSession session)
    {   List<CourseAndYearsDTO> list;
        int teacherId=(Integer)session.getAttribute("id");
        try{
            int i = Integer.parseInt(text);
            list = teacherService.selectStuCourse(teacherId,i,null);
        }
        catch (Exception e)
        {
            list = teacherService.selectStuCourse(teacherId,null,text);
            e.printStackTrace();
        }
        return Result.<List<CourseAndYearsDTO>>builder().res(list).build();
    }

    /**得到本班学生个人课程对应的学号和学年*/
    @GetMapping("getStuOfYear")
    public Result<List<StuCourseOfYearDTO>> selectStuIdAndYearByStuId(Integer studentId)
    {
        List<StuCourseOfYearDTO> list=teacherService.selectStuIdAndYearByStuId(studentId);
        return Result.<List<StuCourseOfYearDTO>>builder().res(list).build();
    }

    /**根据学年统计各个分段学生成绩*/
    @GetMapping("Statistics")
    public Result statistics(Integer year,HttpSession session)
    {
        List l =teacherService.Statistics(year, (Integer)session.getAttribute("id"));

        return Result.builder().res(l).build();
    }

    /*可选择的修改学生成绩*/
    @PutMapping("updateStuCourse")
    public Result<List<StuAndCourseDTO>> updateStuCourse(@RequestBody Course course,HttpSession session)
    {
        //id,chinese,math,english,chemistry,physics,biology,year,teacherId
        teacherService.updateStuCourse(course);
        int year=course.getSchoolYear();
        int id=(Integer) session.getAttribute("id");
        List<StuAndCourseDTO> list=teacherService.selectCourseByYears(year,id);
        return Result.<List<StuAndCourseDTO>>builder().res(list).build();
    }

    /*添加学生成绩（班主任只能添加本班学生的成绩）*/
    @PostMapping("insertCourse")
    public Result<List<StuAndCourseDTO>> insertStuCourse(@RequestBody Course course,HttpSession session)
    {
        //chinese,math,english,chemistry,name,studentId,physics,biology,schoolYears,year,teacherId
        teacherService.insertCourse(course);
        int year=course.getSchoolYear();
        int id=(Integer)session.getAttribute("id");
        List<StuAndCourseDTO> list=teacherService.selectCourseByYears(year,id);
        return Result.<List<StuAndCourseDTO>>builder().res(list).build();
    }


}
