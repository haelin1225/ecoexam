package kr.co.eco.dao;

import java.util.List;

import kr.co.eco.vo.CorrectAnswerVO;

public interface CorrectAnswerDAO {
	public int addCorrectAnswer(CorrectAnswerVO correctAnswerVO);
	public int updateCorrectAnswer(CorrectAnswerVO correctAnswerVO);
	public int deleteCorrectAnswer(String testNo);
	public CorrectAnswerVO getCorrectAnswer(String testNo, int questionNo);
	public List<CorrectAnswerVO> getCorrectAnswerList(String testNo);
	public int sumQuestionPoint(String testNo);
}