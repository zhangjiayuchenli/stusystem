package com.njit.stusystem.controller;

import com.github.pagehelper.PageInfo;
import com.njit.stusystem.dto.AdminDTO;
import com.njit.stusystem.dto.Result;
import com.njit.stusystem.model.Admin;
import com.njit.stusystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("admin/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /*修改管理员信息*/
    @PutMapping("updateAdmin")
    public Result<AdminDTO> updateAdmin(@RequestBody Map<String,String> map)
    {
        Admin admin=new Admin();
        admin.setId(Integer.parseInt(map.get("id"))).setUsername(map.get("name")).setPassword(map.get("password"));
        adminService.updateByPrimaryKey(admin);
        return Result.<AdminDTO>builder().code(Result.SUCCESS_CODE).build();
    }

    //管理员根据类型发送消息
    @PostMapping("sendMessage")
    public Result SendMessage(@RequestBody Map<String,String> map)
    {
        if("all".equals(map.get("sendType")))
        {
            adminService.sendMessageToAll(map.get("description"));
        }
        if("teacher".equals(map.get("sendType")))
        {
            adminService.sendMessageToTeacher(map.get("description"));
        }
        if("student".equals(map.get("sendType")))
        {
            adminService.sendMessageToStu(map.get("description"));
        }
        return Result.builder().code(Result.SUCCESS_CODE).build();
    }
}
