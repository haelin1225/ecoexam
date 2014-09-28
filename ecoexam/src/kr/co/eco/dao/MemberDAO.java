package kr.co.eco.dao;

import java.util.List;

import kr.co.eco.vo.MemberVO;


public interface MemberDAO {
	public int addMember(MemberVO memberVO);
	public int updateMember(MemberVO memberVO);
	public int deleteMember(String memberID);
	public MemberVO getMember(String memberID);
	public List<MemberVO> getMemberList();
}
