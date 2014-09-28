package kr.co.eco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.eco.dao.CorrectAnswerDAO;
import kr.co.eco.service.CorrectAnswerService;
import kr.co.eco.vo.CorrectAnswerVO;

@Service("correctAnswerService")
public class CorrectAnswerServiceImpl implements CorrectAnswerService{
	@Autowired
	private CorrectAnswerDAO dao;
	public int addCorrectAnswer(CorrectAnswerVO correctAnswerVO){
		int add = 0;
		try{
			add = dao.addCorrectAnswer(correctAnswerVO);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return add;
		}
	}
	public CorrectAnswerVO getCorrectAnswer(String testNo, int questionNo){
		return dao.getCorrectAnswer(testNo, questionNo);
	}
	public int updateCorrectAnswer(CorrectAnswerVO correctAnswerVO){
		int upd = 0;
		try{
			upd = dao.updateCorrectAnswer(correctAnswerVO);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return upd;
		}
	}
	public int sumQuestionPoint(String testNo){
		return dao.sumQuestionPoint(testNo);
	}
}
