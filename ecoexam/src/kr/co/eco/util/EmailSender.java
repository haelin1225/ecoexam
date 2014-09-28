package kr.co.eco.util;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import kr.co.eco.vo.EmailVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	
	@Autowired
	protected JavaMailSender mailSender;
	
	public void SendEmail(EmailVO emailVO) throws Exception {
		MimeMessage msg = mailSender.createMimeMessage();
		msg.setSubject(emailVO.getSubject());
		msg.setText(emailVO.getContent());
		msg.setRecipient(RecipientType.TO, new InternetAddress(emailVO.getReciver()));
		mailSender.send(msg);
	}
	
}

