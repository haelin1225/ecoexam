package kr.co.eco.controller;

import java.util.Random;

import kr.co.eco.util.EmailSender;
import kr.co.eco.vo.EmailVO;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
	@Autowired
	private EmailSender emailSender;
	
	@RequestMapping("email.eco")
	public @ResponseBody String sendEmailAction(String memberEmail) {
		EmailVO emailVO = new EmailVO();
		Random rnd =new Random();
		StringBuffer buf =new StringBuffer();
		 
		for(int i=0;i<6;i++){			// ������ȣ ���� �ڵ�
		    if(rnd.nextBoolean()){
		        buf.append((char)((int)(rnd.nextInt(26))+97));
		    }else{
		        buf.append((rnd.nextInt(10))); 
		    }
		}

		System.out.println("������ȣ�Ե� : " + buf.toString());
		
		String receiver = memberEmail;
		String subject = "ȸ������ ������ȣ";
		String content = "ȸ������ ������ȣ : " + buf.toString();
		System.out.println("content��" + content);

		emailVO.setReciver(receiver);		// form�� �Է��� Email�ּ�
		emailVO.setSubject(subject);		// ����
		emailVO.setContent(content);		// ������ȣ

		try {
			emailSender.SendEmail(emailVO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject jobj = new JSONObject();
		jobj.put("content", buf.toString());
		System.out.println(jobj.toString());
		return jobj.toString();
	}
	
	@RequestMapping("emailCheck.eco")
	public @ResponseBody String emailCheck(String authoCheck) {
		System.out.println(authoCheck);
		JSONObject jobj = new JSONObject();
		jobj.put("emailCheck", authoCheck);
		
		return jobj.toString();
	}
}
