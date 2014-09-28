package kr.co.eco.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.co.eco.vo.CommentsVO;
import kr.co.eco.vo.CorrectAnswerVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class CorrectAnswerDAOTest {

	@Autowired
	CorrectAnswerDAO dao;
	
	@Test
	public void addCorrectAnswer() {
		CorrectAnswerVO correctAnswer = new CorrectAnswerVO();
		correctAnswer.setTestNo("N88");
		correctAnswer.setQuestionNo(1);
		correctAnswer.setQuestionPoint(3);
		correctAnswer.setCorrectAnswer("1¹ø");

		int count = dao.addCorrectAnswer(correctAnswer);
		//assertEquals(1, count);
	}
	
	@Test
	public void updateCorrectAnswer() {
		CorrectAnswerVO correctAnswer = dao.getCorrectAnswer("N3", 1);
		correctAnswer.setQuestionPoint(5);
		correctAnswer.setCorrectAnswer("2¹ø");

		int count = dao.updateCorrectAnswer(correctAnswer);
		assertEquals(1, count);
	}
	
	@Test
	public void deleteCorrectAnswer() {
		int count = dao.deleteCorrectAnswer("N3");
		assertEquals(1, count);
	}
	
	@Test
	public void getCorrectAnswerList() {
		List<CorrectAnswerVO> list = dao.getCorrectAnswerList("N3");
		assertEquals(1, list.size());
		
		for(CorrectAnswerVO answer : list) {
			System.out.println(answer);
		}
	}
	
	@Test
	public void sumQuestionPoint(){
		int sum = dao.sumQuestionPoint("N63");
		assertEquals(21, sum);
	}
}
