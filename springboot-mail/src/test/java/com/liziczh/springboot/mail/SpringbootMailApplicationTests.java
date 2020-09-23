package com.liziczh.springboot.mail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liziczh.springboot.mail.service.MailService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = SpringbootMailApplication.class)
@SpringBootTest
@ActiveProfiles("test")
class SpringbootMailApplicationTests {
	@Autowired
	private MailService mailService;

	@Test
	void sendMailTest() {
		mailService.sendTextMail("subject", "123456Test", new String[] { "1779457645@qq.com" }, null, null);
	}
}
