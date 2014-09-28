package kr.co.eco.service;

import kr.co.eco.vo.QuestionVO;

public interface QuestionService {

	public int countQuestion(String testNo);
	public int addQuestion(QuestionVO questionVO);
	public QuestionVO getQuestion(String testNo, int questionNo);
	public int updateQuestion(QuestionVO questionVO);
}
