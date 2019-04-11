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
    private String uesrName="qaq";

    public static String verifyCode;

    /*发送邮件，随机验证码*/
    public boolean sendWithHTMLTemplate(String email) {
        try {
            //发件人的昵称
            String nick = MimeUtility.encodeText(uesrName);
            //发件人是谁
            InternetAddress from = new InternetAddress(nick + "<1352029800@qq.com>");
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject("登录验证码");
            verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
            mimeMessageHelper.setText("你的验证码为"+verifyCode);
            javaMailSender.send(mimeMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
