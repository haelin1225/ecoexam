package kr.co.eco.service;

import kr.co.eco.vo.CorrectAnswerVO;

public interface CorrectAnswerService {
	
	public int addCorrectAnswer(CorrectAnswerVO correctAnswerVO);
	public CorrectAnswerVO getCorrectAnswer(String testNo, int questionNo);
	public int updateCorrectAnswer(CorrectAnswerVO correctAnswerVO);
	public int sumQuestionPoint(String testNo);
}
