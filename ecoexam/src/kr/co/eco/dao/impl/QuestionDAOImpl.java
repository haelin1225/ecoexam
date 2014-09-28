package kr.co.eco.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.eco.dao.QuestionDAO;
import kr.co.eco.vo.QuestionVO;

@Repository("questionDAO")
public class QuestionDAOImpl implements QuestionDAO {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public int addQuestion(QuestionVO questionVO) {
		return sqlMapClientTemplate.update("insertQuestion", questionVO);
	}

	public int updateQuestion(QuestionVO questionVO) {
		return sqlMapClientTemplate.update("updateQuestion", questionVO);
	}

	public int deleteQuestion(String testNo, int questionNo) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("testNo", testNo);
		parameters.put("questionNo", questionNo);
		return sqlMapClientTemplate.delete("deleteQuestion", parameters);
	}

	public List<QuestionVO> getQuestionList(String testNo) {
		return sqlMapClientTemplate.queryForList("questionList", testNo);
	}
	public int countQuestion(String testNo){
		return (int) sqlMapClientTemplate.queryForObject("countQuestion", testNo);
	}

	public QuestionVO getQuestion(String testNo, int questionNo) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("testNo", testNo);
		parameters.put("questionNo", questionNo);
		return (QuestionVO) sqlMapClientTemplate.queryForObject("getQuestion",parameters);
	}

}
