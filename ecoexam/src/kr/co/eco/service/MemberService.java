package kr.co.eco.service;

import kr.co.eco.vo.MemberVO;

public interface MemberService {

	public int addMember(MemberVO memberVO);
	public MemberVO getMember(String memberID);
	public MemberVO getMember(String memberID, String memberPW);
	public int updateMember(String memberID, String memberPW, String memberEmail);
	public int deleteMember(String memberID);
}
