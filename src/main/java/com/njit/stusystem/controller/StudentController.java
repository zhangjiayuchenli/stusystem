package com.njit.stusystem.controller;

import com.njit.stusystem.dto.CourseAndYearsDTO;
import com.njit.stusystem.dto.Result;
import com.njit.stusystem.dto.StuAndCourseDTO;
import com.njit.stusystem.dto.TeaAndStuDTO;
import com.njit.stusystem.model.Student;
import com.njit.stusystem.model.Teacher;
import com.njit.stusystem.service.StudentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("student/")
@Api("相关api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*查询所有学生信息*/
    @GetMapping("selectAll")
    public Result<List<TeaAndStuDTO>> selectAll()
    {
        List<TeaAndStuDTO> list=studentService.selectAll();
        return Result.<List<TeaAndStuDTO>>builder().res(list).build();
    }

    /*上传头像*/
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
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();//父目录不存在则新建文件
        }
        System.out.println("绝对路径:"+dest);
        try {
            //将文件保存到本地
            file.transferTo(dest);
            student.setId((Integer) session.getAttribute("id"));
            System.out.println((Integer) session.getAttribute("id"));
            student.setStudentAvatar("http://localhost:8080/image/"+fileName);
            studentService.updateByPrimaryKeySelective(student);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return Result.builder().code(Result.SUCCESS_CODE).res("http://localhost:8080/image/"+fileName).build();
    }

    @GetMapping("selectCourseByYears")
    public Result<StuAndCourseDTO> selectCourseByYears(Integer year, Integer id)
    {
        return Result.<StuAndCourseDTO>builder().res(studentService.selectCourseByStuIdAndYear(id,year)).build();

    }

    /*修改学生信息*/
    @PutMapping("updateStu")
    public Result<List<TeaAndStuDTO>> updateStu(@RequestBody Map<String,String> map){
        Student student=new Student();
        student.setId(Integer.parseInt(map.get("id")));
        student.setStudentName(map.get("name"));
        student.setStudentEmail(map.get("email"));
        student.setStudentPassword(map.get("password"));
        student.setStudentPhone(map.get("phone"));
        student.setStudentAddress(map.get("address"));
        student.setStudentBirthday(map.get("birthday"));
        student.setStudentSex(map.get("sex"));
        if(map.get("teacherId")!=null)
        {
            student.setTeacherId(Integer.parseInt(map.get("teacherId")));
        }
        studentService.updateByPrimaryKeySelective(student);
        List<TeaAndStuDTO> list=studentService.selectAll();
        return Result.<List<TeaAndStuDTO>>builder().res(list).build();
    }

    @GetMapping("selectCourseByStuId")
    public Result<List<CourseAndYearsDTO>> selectCourseByStuId(Integer stuId)
    {
        List<CourseAndYearsDTO> list=studentService.selectCourseByStuId(stuId);
        return Result.<List<CourseAndYearsDTO>>builder().res(list).build();
    }

    /*新增学生信息*/
    @PostMapping("insertStu")
    public Result<List<TeaAndStuDTO>> insertStu(@RequestBody Map<String,String> map)
    {
        Student student=new Student();
        student.setStudentName(map.get("name"));
        student.setStudentEmail(map.get("email"));
        student.setStudentPassword(map.get("password"));
        student.setStudentPhone(map.get("phone"));
        student.setStudentAddress(map.get("address"));
        student.setStudentBirthday(map.get("birthday"));
        student.setStudentSex(map.get("sex"));
        student.setTeacherId(Integer.parseInt(map.get("teacherId")));
        studentService.insertSelective(student);
        List<TeaAndStuDTO> list=studentService.selectAll();
        return Result.<List<TeaAndStuDTO>>builder().res(list).build();

    }

    /*删除学生信息*/
    @DeleteMapping("deleteStu")
    public Result<List<TeaAndStuDTO>> deleteStu(@RequestBody Map<String,String> map)
    {
        studentService.deleteByPrimaryKey(Integer.parseInt(map.get("id")));
        List<TeaAndStuDTO> list=studentService.selectAll();
        return Result.<List<TeaAndStuDTO>>builder().res(list).build();
    }

    /*多选删除学生信息*/
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
