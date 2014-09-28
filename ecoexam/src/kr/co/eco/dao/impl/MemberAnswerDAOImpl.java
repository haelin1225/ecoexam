package kr.co.eco.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.eco.dao.MemberAnswerDAO;
import kr.co.eco.vo.MemberAnswerVO;

@Repository("memberAnswerDAO")
public class MemberAnswerDAOImpl implements MemberAnswerDAO {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public int addMemberAnswer(MemberAnswerVO memberAnswerVO) {
		return sqlMapClientTemplate.update("insertMemberAnswer", memberAnswerVO);
	}

	public int deleteMemberAnswer(String testNo, String memberID) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("testNo", testNo);
		parameters.put("memberID", memberID);
		return sqlMapClientTemplate.delete("deleteMemberAnswer", parameters);
	}

	public List<MemberAnswerVO> getMemberAnswer(String testNo, String memberID) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("testNo", testNo);
		parameters.put("memberID", memberID);
		return sqlMapClientTemplate.queryForList("memberAnswerList", parameters);
	}

}
