package kr.co.eco.dao;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import junit.framework.Assert;

import kr.co.eco.util.EmailSender;
//import kr.co.eco.util.EmailSender;
import kr.co.eco.vo.EmailVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:./resource/applicationContext.xml" })
public class EmailTest {

	// @Autowired
	// private EmailSender emailSender;
	//
	// @Test
	// public void testSendMail() throws Exception {
	// EmailVO emailVO = new EmailVO();
	//
	// emailVO.setContent("¾È³ç");
	// emailVO.setReciver("jihun7056@nate.com");
	// emailVO.setSubject("¾È³ç");
	//
	// emailSender.SendEmail(emailVO);
	// }


}
