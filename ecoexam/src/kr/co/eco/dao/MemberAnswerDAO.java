package kr.co.eco.dao;

import java.util.List;

import kr.co.eco.vo.MemberAnswerVO;

public interface MemberAnswerDAO {
	public int addMemberAnswer(MemberAnswerVO memberAnswerVO);
	public int deleteMemberAnswer(String testNo, String memberID);
	public List<MemberAnswerVO> getMemberAnswer(String testNo, String memberID);
}
