package com.liziczh.springboot.mail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.liziczh.springboot.mail.dto.MailSendReq;
import com.liziczh.springboot.mail.dto.MailSendResult;
import com.liziczh.springboot.mail.service.MailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class MailApplicationTests {

    @Autowired
    private MailService mailService;

    @Value("${spring.mail.username}")
    private String username;

    @Test
    void sendMailTest() {
        MailSendReq req = new MailSendReq();
        req.setSubject("Test");
        req.setContent("Test content......");
        req.setFrom(username);
        req.setTo(new String[]{"liziczh@foxmail.com"});
        MailSendResult result = mailService.sendTextMail(req);
        log.info("sendMailTest, result={}", result);
    }

}
