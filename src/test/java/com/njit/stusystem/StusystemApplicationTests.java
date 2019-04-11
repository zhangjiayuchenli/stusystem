package com.njit.stusystem;

import com.njit.stusystem.mapper.AdminMapper;
import com.njit.stusystem.service.AdminService;
import com.njit.stusystem.service.TeacherService;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StusystemApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    StringEncryptor stringEncryptor;//密码解码器

    @Value("${spring.datasource.password}")
    private String password;

    @Test
    public void test()
    {
        System.out.println("连接数据库密码: "+password);
        System.out.println("查询信息: "+adminMapper.selectByPrimaryKey(1));
    }

    @Test
    public void encryptPwd() {
        String result = stringEncryptor.encrypt("zhang1314");
        System.out.println("==================");
        System.out.println(result);
        System.out.println("==================");
    }
}
