package kr.co.eco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.eco.dao.QuestionDAO;
import kr.co.eco.service.QuestionService;
import kr.co.eco.vo.QuestionVO;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService{
@Autowired
private QuestionDAO questionDAO;

	public int countQuestion(String testNo) {
		return questionDAO.countQuestion(testNo);
	}
	public int addQuestion(QuestionVO questionVO){
		int add = 0;
		try{
			add = questionDAO.addQuestion(questionVO);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return add;
		}
	}
	public QuestionVO getQuestion(String testNo, int questionNo){
		QuestionVO qVO = null;
		if(questionDAO.getQuestion(testNo, questionNo)!=null){
			qVO = questionDAO.getQuestion(testNo, questionNo);
		}

		return qVO;
	}
	public int updateQuestion(QuestionVO questionVO){
		int upd = 0;
		try{
			upd = questionDAO.updateQuestion(questionVO);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return upd;
		}
	}
}
