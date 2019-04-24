package com.njit.stusystem.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.njit.stusystem.annotation.LoginToken;
import com.njit.stusystem.annotation.PassToken;
import com.njit.stusystem.service.AdminService;
import com.njit.stusystem.service.MailSendService;
import com.njit.stusystem.service.StudentService;
import com.njit.stusystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author ZJY
 * @version 1.0
 * @date 2019/4/22 15:42
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(LoginToken.class)) {
            LoginToken userLoginToken = method.getAnnotation(LoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userId;
                String type;
                try {
                    userId = JWT.decode(token).getAudience().get(0);
                    type=JWT.decode(token).getAudience().get(1);
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("401");
                }
                String teacher="teacher";
                String stu="stu";
                String admin="admin";
                if(type.equals(teacher))
                {
                    if(teacherService.selectById(Integer.parseInt(userId))==null)
                    {
                        throw new RuntimeException("用户不存在，请重新登录");
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
                    if(adminService.selectById(Integer.parseInt(userId))==null)
                    {
                        throw new RuntimeException("用户不存在，请重新登录");
                    }
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("123")).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401");
                }
                return true;
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
