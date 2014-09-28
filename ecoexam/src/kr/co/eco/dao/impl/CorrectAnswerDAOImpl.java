package kr.co.eco.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.eco.dao.CorrectAnswerDAO;
import kr.co.eco.vo.CorrectAnswerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository("CorrectAnswerDAO")
public class CorrectAnswerDAOImpl implements CorrectAnswerDAO{
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	public int addCorrectAnswer(CorrectAnswerVO correctAnswerVO) {
		return sqlMapClientTemplate.update("addCorrectAnswer", correctAnswerVO);
	}

	public int updateCorrectAnswer(CorrectAnswerVO correctAnswerVO) {
		return sqlMapClientTemplate.update("updateCorrectAnswer", correctAnswerVO);
	}

	public int deleteCorrectAnswer(String testNo) {
		return sqlMapClientTemplate.delete("deleteCorrectAnswer", testNo);
	}
	
	public CorrectAnswerVO getCorrectAnswer(String testNo, int questionNo) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("testNo", testNo);
		parameters.put("questionNo", questionNo);
		return (CorrectAnswerVO)sqlMapClientTemplate.queryForObject("getCorrectAnswer", parameters);
	}

	public List<CorrectAnswerVO> getCorrectAnswerList(String testNo) {
		return (List<CorrectAnswerVO>)sqlMapClientTemplate.queryForList("getCorrectAnswerList", testNo);
	}
	public int sumQuestionPoint(String testNo){
		return (int)sqlMapClientTemplate.queryForObject("sumQuestionPoint", testNo);
	}
	
}