package com.njit.stusystem.controller;

import com.njit.stusystem.dto.*;
import com.njit.stusystem.model.Student;
import com.njit.stusystem.model.Teacher;
import com.njit.stusystem.service.AdminService;
import com.njit.stusystem.service.MailSendService;
import com.njit.stusystem.service.StudentService;
import com.njit.stusystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private MailSendService mailSendService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    /*退出登录，清除session*/
    @GetMapping("/logout")
    public void clearSession(HttpSession session)
    {
        session.removeAttribute("id");
    }


    /* 登录验证，先判断用户类型，再进行用户名和密码的确认
       type=a为管理员，type=b为教师，type=c为学生用户 */
    @PostMapping("/login")
    public Result validate(@RequestBody UserDTO user, HttpSession session){

        if (user.getId() == null ) {
            return Result.builder().code(Result.FAILED_CODE).build();
        }
        else if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return Result.builder().code(Result.FAILED_CODE).build();
        }
        else if("admin".equals(user.getTypes()))
        {
            int userId = user.getId();
            String password=user.getPassword();
            AdminDTO adminDTO=adminService.selectByUsernameAndPassword(userId,password);
            if (adminDTO!=null&&userId==adminDTO.getId() && password.equals(adminDTO.getPassword())) {
                session.setAttribute("id",userId);
                return Result.<AdminDTO>builder().code(Result.SUCCESS_CODE).build();
            }
        }
        else if ("teacher".equals(user.getTypes()))
        {
            int userId = user.getId();
            String password=user.getPassword();
            TeacherDTO teacher=teacherService.selectByUsernameAndPassword(userId, password);
            if (userId==teacher.getId() && password.equals(teacher.getTeacherPassword())) {
                session.setAttribute("id",userId);
                System.out.println(teacher.getTeacherName());
                return Result.<TeacherDTO>builder().code(Result.SUCCESS_CODE).res(teacher).build();
            }
        }
        else if ("stu".equals(user.getTypes()))
        {
            int userId = user.getId();
            String password=user.getPassword();
            StudentDTO studentDTO=studentService.selectByUsernameAndPassword(userId,password);
            if (userId==studentDTO.getId() && password.equals(studentDTO.getStudentPassword())) {
                session.setAttribute("id",userId);
                System.out.println("studentName:");
                System.out.println(studentDTO.getStudentName());
                return Result.<StudentDTO>builder().code(Result.SUCCESS_CODE).res(studentDTO).build();
            }
        }
        else{System.out.println("***************");}
        System.out.println("---------------------");
        return Result.builder().code(Result.FAILED_CODE).build();

    }

    /* 忘记密码：发送验证码到指定邮箱 */
    @GetMapping("/sendCaptcha")
    public Result sendCaptcha(String email)
    {
        if(teacherService.selectEmail(email)!=null||studentService.selectByEmail(email)!=null)
        {
            mailSendService.sendWithHTMLTemplate(email);

            return Result.builder().code(Result.SUCCESS_CODE).build();
        }
        return Result.builder().code(Result.FAILED_CODE).build();
    }

    /* 忘记密码：验证验证码是否正确，暂未将验证码存入Session和设置失效 */
    @GetMapping("/validateCaptcha")
    public Result validateCaptcha(Integer captcha)
    {
        if (Integer.parseInt(MailSendService.verifyCode)==captcha)
        {
            return Result.builder().code(Result.SUCCESS_CODE).build();
        }
        return Result.builder().code(Result.FAILED_CODE).error("验证码错误").build();
    }

    /* 忘记密码：修改用户的密码*/
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Map<String,String> map)
    {
        if (MailSendService.verifyCode.equals(map.get("captcha")))
        {
            if (teacherService.selectEmail(map.get("email"))!=null)
            {
                Teacher teacher=new Teacher();
                teacher.setId(teacherService.selectEmail(map.get("email")).getId());
                teacher.setTeacherPassword(map.get("password"));
                teacherService.updateByPrimaryKeySelective(teacher);
                return Result.builder().code(Result.SUCCESS_CODE).build();
            }
            if (studentService.selectByEmail(map.get("email"))!=null)
            {
                Student student=new Student();
                student.setId(studentService.selectByEmail(map.get("email")).getId());
                student.setStudentPassword(map.get("password"));
                studentService.updateByPrimaryKeySelective(student);
                return Result.builder().code(Result.SUCCESS_CODE).build();
            }
        }
        return Result.builder().code(Result.FAILED_CODE).build();
    }
}
