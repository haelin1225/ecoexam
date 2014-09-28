package kr.co.eco.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.eco.service.MemberService;
import kr.co.eco.vo.MemberVO;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
/*
	EXAMPLE
	
	@Autowired
	private Service service;
	
	@RequestMapping("index.sku")
	public ModelAndView Index(){		
		ModelAndView mv = new ModelAndView("index.html");
		mv.addObject("object",service.getList());		
		return mv;
	}
*/
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("myPageIndex.eco")
	public String myPageIndex(){		
		return "myPageIndex";
	}
	
	@RequestMapping("joinForm.eco")
	public ModelAndView joinForm() {
		ModelAndView mv = new ModelAndView("joinForm");	
		return mv;
	}
	
	@RequestMapping("join.eco")
	public ModelAndView join(MemberVO memberVO) {
		ModelAndView mv = new ModelAndView("join");
		memberService.addMember(memberVO);
		return mv;
	}
	
	@RequestMapping("loginForm.eco")
	public ModelAndView loginForm() {
		ModelAndView mv = new ModelAndView("loginForm");
		mv.addObject("object", "object");
		return mv;
	}
	
	@RequestMapping("login.eco")
	public String login(String memberID, String memberPW, HttpSession session, HttpServletResponse response) {
		session.getAttribute(memberID);
		MemberVO member = memberService.getMember(memberID, memberPW);
		if(member != null) {
			session.setAttribute("loginInfo", member);
			return "redirect:/"+ response.encodeURL("main.eco");
		}
		return "error";
	}
	
	@RequestMapping("logout.eco")
	public String logout(HttpSession session){
		session.removeAttribute("loginInfo");
		return "redirect:/main.eco";		
	}
	
	@RequestMapping("myPageEditForm.eco")
	public ModelAndView myPageEditForm() {
		ModelAndView mv = new ModelAndView("myPageEditForm");
		mv.addObject("object", "object");		
		return mv;
	}
	
	@RequestMapping("myPageEdit.eco")
	public String myPageEdit(HttpSession session, String memberPW, String memberEmail) {
		MemberVO member = (MemberVO) session.getAttribute("loginInfo");

		int count = memberService.updateMember(member.getMemberID(), memberPW, memberEmail);
		if(count != 0) {
			session.setAttribute("loginInfo", memberService.getMember(member.getMemberID()));
			return "myPageEdit";
		}
		return "error";
	}
	
	@RequestMapping("leaveForm.eco")
	public ModelAndView leaveForm() {
		ModelAndView mv = new ModelAndView("leaveForm");
		mv.addObject("object", "object");		
		return mv;
	}
	
	@RequestMapping("leave.eco")
	public ModelAndView leave(String memberID) {
		ModelAndView mv = new ModelAndView("leave");
		memberService.deleteMember(memberID);	
		
		return mv;
	}
	
	
	// 다시 확인
	@RequestMapping("idCheck.eco")
	public @ResponseBody String getMember(String memberID) {
		System.out.println(memberID);
		MemberVO memberVO = memberService.getMember(memberID);
		System.out.println(memberVO);
		JSONObject jobj = new JSONObject();
		if(memberVO == null)
			jobj.put("memberVO", "possible");
		else
			jobj.put("memberVO", memberVO);
		
		System.out.println(jobj.toString());
		return jobj.toString();
	}
	
/*	@RequestMapping("getMember.bis")
	   public @ResponseBody String getMember(String id){
	      System.out.println("아이디닷!!!!!!!"+id);
	      MemberVO memberVO = memberService.getMember(id);
	      
	      JSONObject jobj=new JSONObject();
	      jobj.put("mvo", memberVO);
	      System.out.println(jobj.toString()+"controller~~");
	      return jobj.toString();
	   }*/

}
