package com.njit.stusystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.Random;

@Service
public class MailSendService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String userName="qaq";

    private  String verifyCode;

    /*发送邮件，随机验证码*/
    public String sendWithHTMLTemplate(String email) {
        try {
            //发件人的昵称
            String nick = MimeUtility.encodeText(userName);
            //发件人是谁
            InternetAddress from = new InternetAddress(nick + "<1352029800@qq.com>");
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject("登录验证码");
            verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
            mimeMessageHelper.setText("您的验证码为: "+verifyCode+",有效时间为两分钟");
            javaMailSender.send(mimeMessage);
            return verifyCode;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
