package com.njit.stusystem.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZJY
 * @version 1.0
 * @date 2019/4/18 14:02
 *
 * 使用 browserHistory ，创建一个 controller ，暂时办法
 */
@Controller
public class AntDesignController implements ErrorController {
    @Override
    public String getErrorPath(){
        return "/error";
    }

    @RequestMapping(value = "/error")
    public String getIndex(){
        // 返回index页面
        return "index";
    }
}
