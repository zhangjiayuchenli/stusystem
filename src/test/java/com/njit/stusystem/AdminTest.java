package com.njit.stusystem;

import com.njit.stusystem.mapper.AdminMapper;
import com.njit.stusystem.mapper.MessageMapper;
import com.njit.stusystem.model.Admin;
import com.njit.stusystem.model.Student;
import com.njit.stusystem.service.AdminService;
import com.njit.stusystem.service.MailSendService;
import com.njit.stusystem.utils.MD5Util;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminTest extends BaseTest {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Autowired
    private MailSendService mailSendService;

    @Autowired
    private MessageMapper messageMapper;
    @Test
    public void testDelete()
    {
        System.out.println(messageMapper.selectUnReadCounts(6));
    }

    @Test
    public void sendWithHTMLTemplate() {

        Admin admin=new Admin();
        admin.setId(3).setPassword(MD5Util.MD5("123")).setUsername("李老师");
        adminMapper.insert(admin);
    }
}
