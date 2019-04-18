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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ZJY
 * @version 1.0
 * @date 2019/4/15 17:38
 *
 * 登录控制类，前台代码打包到后台后，需在每个类的RequestMapping加上("/dev")
 * 或者前台url统一删除dev
 */
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

    /**退出登录，清除session*/
    @GetMapping("/logout")
    public void clearSession(HttpSession session)
    {
        session.removeAttribute("id");
        session.removeAttribute("type");
    }


    /** 登录验证，先判断用户类型，再进行用户名和密码的确认
       type=admin为管理员，type=teacher为教师，type=stu为学生用户 */
    @PostMapping("/login")
    public Result validate(@RequestBody UserDTO user, HttpSession session){
        String teacher="teacher";
        String stu="stu";
        String admin="admin";
        int userId = user.getId();
        String password=user.getPassword();
        // 前台已经做了强制输入用户名和密码处理，后台不必判断id和password为空的情况
        if(admin.equals(user.getTypes()))
        {
            AdminDTO adminDTO=adminService.selectByUsernameAndPassword(userId,password);
            if (adminDTO!=null&&userId==adminDTO.getId() && password.equals(adminDTO.getPassword())) {
                session.setAttribute("id",userId);
                session.setAttribute("type",user.getTypes());
                return Result.<AdminDTO>builder().code(Result.SUCCESS_CODE).build();
            }
        }
        else if (teacher.equals(user.getTypes()))
        {
            TeacherDTO teacherDTO=teacherService.selectByUsernameAndPassword(userId, password);
            if (teacherDTO!=null && userId==teacherDTO.getId() && password.equals(teacherDTO.getTeacherPassword())) {
                session.setAttribute("id",userId);
                session.setAttribute("type",user.getTypes());
                return Result.<TeacherDTO>builder().code(Result.SUCCESS_CODE).res(teacherDTO).build();
            }
        }
        else if (stu.equals(user.getTypes()))
        {
            StudentDTO studentDTO=studentService.selectByUsernameAndPassword(userId,password);
            if (studentDTO!=null &&userId==studentDTO.getId() && password.equals(studentDTO.getStudentPassword())) {
                session.setAttribute("id",userId);
                session.setAttribute("type",user.getTypes());
                return Result.<StudentDTO>builder().code(Result.SUCCESS_CODE).res(studentDTO).build();
            }
        }
        return Result.builder().code(Result.FAILED_CODE).build();

    }

    /** 忘记密码：发送验证码到指定邮箱 */
    @GetMapping("/sendCaptcha")
    public Result sendCaptcha(String email,HttpSession session)
    {
        if(teacherService.selectEmail(email)!=null||studentService.selectByEmail(email)!=null)
        {
            String verifyCode=mailSendService.sendWithHTMLTemplate(email);
            session.setAttribute("verifyCode",verifyCode);
            try{
                ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
                executorService.scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {
                        session.removeAttribute("verifyCode");
                        System.out.println("run "+ System.currentTimeMillis());
                    }
                }, 2, 2, TimeUnit.MINUTES);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return Result.builder().code(Result.SUCCESS_CODE).build();
        }
        return Result.builder().code(Result.FAILED_CODE).build();
    }

    /** 忘记密码：验证验证码是否正确，暂未将验证码存入Session和设置失效 */
    @GetMapping("/validateCaptcha")
    public Result validateCaptcha(Integer captcha,HttpSession session)
    {
        int code=(Integer) session.getAttribute("verifyCode");
        if (code==captcha)
        {
            return Result.builder().code(Result.SUCCESS_CODE).build();
        }
        return Result.builder().code(Result.FAILED_CODE).error("验证码错误").build();
    }

    /** 忘记密码：修改用户的密码*/
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Map<String,String> map,HttpSession session)
    {
        String code=(String) session.getAttribute("verifyCode");
        System.out.println(code);
        if (code!=null&&code.equals(map.get("captcha")))
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
