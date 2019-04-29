package com.njit.stusystem.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.njit.stusystem.annotation.LoginToken;
import com.njit.stusystem.annotation.PassToken;
import com.njit.stusystem.dto.AdminDTO;
import com.njit.stusystem.dto.TeacherDTO;
import com.njit.stusystem.model.Admin;
import com.njit.stusystem.service.AdminService;
import com.njit.stusystem.service.MailSendService;
import com.njit.stusystem.service.StudentService;
import com.njit.stusystem.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author ZJY
 * @version 1.0
 * @date 2019/4/22 15:42
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        log.info(token);
        if (!(object instanceof HandlerMethod)) {
            log.info("1");
            return true;
        }
        log.info("2");
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(com.njit.stusystem.annotation.PassToken.class)) {
            com.njit.stusystem.annotation.PassToken passToken = method.getAnnotation(com.njit.stusystem.annotation.PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(com.njit.stusystem.annotation.LoginToken.class)) {
            com.njit.stusystem.annotation.LoginToken userLoginToken = method.getAnnotation(com.njit.stusystem.annotation.LoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userId;
                String type;
                log.info("3");
                try {
                    userId = JWT.decode(token).getAudience().get(0);
                    System.out.println(JWT.decode(token).getAudience().get(0));
                    System.out.println("**********************");
                    type=JWT.decode(token).getAudience().get(1);

                } catch (JWTDecodeException j) {
                    throw new RuntimeException("401");
                }
                String teacher="teacher";
                String stu="stu";
                String admin="admin";
                if(type.equals(teacher))
                {
                    TeacherDTO teacherDTO=teacherService.selectById(Integer.parseInt(userId));

                    if(teacherDTO==null)
                    {
                        throw new RuntimeException("用户不存在，请重新登录");
                    }
                    else
                    {
                        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(teacherDTO.getTeacherPassword())).build();
                        // 验证 token
                        try {
                            jwtVerifier.verify(token);
                        } catch (JWTVerificationException e) {
                            throw new RuntimeException("401");
                        }
                        HttpSession session=httpServletRequest.getSession();
                        String uid = (String)session.getAttribute("id");
                        if(uid == null){
                            session.setAttribute("id",userId);
                        }
                        String types = (String)session.getAttribute("type");
                        if(types == null){
                            session.setAttribute("type",type);
                        }
                        return true;
                    }
                }
                if(type.equals(stu))
                {
                    if(studentService.selectCourseByStuId(Integer.parseInt(userId))==null)
                    {
                        throw new RuntimeException("用户不存在，请重新登录");
                    }
                }
                if(type.equals(admin))
                {
                    Admin adminDto=adminService.selectById(Integer.parseInt(userId));
                    if(adminDto==null)
                    {
                        throw new RuntimeException("用户不存在，请重新登录");
                    }
                    else
                    {
                        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(adminDto.getPassword())).build();
                        // 验证 token
                        try {
                            jwtVerifier.verify(token);
                        } catch (JWTVerificationException e) {
                            throw new RuntimeException("401");
                        }
                        HttpSession session=httpServletRequest.getSession();
                        String uid = (String)session.getAttribute("id");
                        if(uid == null){
                            session.setAttribute("id",userId);
                        }
                        String types = (String)session.getAttribute("type");
                        if(types == null){
                            session.setAttribute("type",type);
                        }
                        return true;
                    }
                }
                // 验证 token

            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
