package kr.co.eco.dao;

import java.util.List;

import kr.co.eco.vo.QuestionVO;

public interface QuestionDAO {
	public int addQuestion(QuestionVO questionVO);
	public int updateQuestion(QuestionVO questionVO);
	public int deleteQuestion(String testNo, int questionNo);
	public List<QuestionVO> getQuestionList(String testNo);
	public QuestionVO getQuestion(String testNo, int questionNo);
	public int countQuestion(String testNo);
	
}
