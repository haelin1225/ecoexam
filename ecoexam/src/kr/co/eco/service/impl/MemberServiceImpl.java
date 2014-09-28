package kr.co.eco.service.impl;

import kr.co.eco.dao.MemberDAO;
import kr.co.eco.service.MemberService;
import kr.co.eco.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	public int addMember(MemberVO memberVO) {
		return memberDAO.addMember(memberVO);
	}
	
	public MemberVO getMember(String memberID) {
		return memberDAO.getMember(memberID);
	}
	
	
	@Override
	public MemberVO getMember(String memberID, String memberPW) {
		MemberVO member = memberDAO.getMember(memberID);
		if(member != null) {
			if(memberPW.equals(member.getMemberPW())) {
				return member;
			}
		}
		return null;
	}
	
	@Override
	public int updateMember(String memberID, String memberPW, String memberEmail) {
		MemberVO memberVO = memberDAO.getMember(memberID);
		memberVO.setMemberPW(memberPW);
		memberVO.setMemberEmail(memberEmail);

		return memberDAO.updateMember(memberVO);
	}
	
	@Override
	public int deleteMember(String memberID) {
		return memberDAO.deleteMember(memberID);
	}
}
