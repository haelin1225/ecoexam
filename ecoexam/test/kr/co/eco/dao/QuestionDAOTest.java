package kr.co.eco.dao;

import kr.co.eco.vo.QuestionVO;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class QuestionDAOTest {
	@Autowired
	private QuestionDAO questionDAO;
	private QuestionVO questionVO;
	
	@Test
	public void testAddQuestion() {
		questionVO = new QuestionVO();
		questionVO.setQuestion("����");
		questionVO.setQuestionContent("��������");
		questionVO.setQuestionKind("�ְ���");
		questionVO.setQuestionNo(1);
		questionVO.setTestNo("N88");
		
		int count = questionDAO.addQuestion(questionVO);
		assertEquals(1, count);
	}
	
	@Test
	public void testUpdateQuestion() {
		questionVO = new QuestionVO();
		questionVO.setQuestionNo(5);
		questionVO.setTestNo("A01");
		questionVO.setQuestion("��������");
		questionVO.setQuestionContent("��������");
		questionVO.setQuestionKind("�ְ�");
		
		int count = questionDAO.updateQuestion(questionVO);
		assertEquals(1, count);
	}
	
	@Test
	public void testDeleteQuestion() {
		questionVO = new QuestionVO();
		questionVO.setTestNo("A01");
		questionVO.setQuestionNo(5);
		
		int count = questionDAO.deleteQuestion(questionVO.getTestNo(), questionVO.getQuestionNo());
		
		assertEquals(1, count);
	}
	
	@Test
	public void testGetQuestion() {
		questionVO = new QuestionVO();
		questionVO.setTestNo("A01");
		
		assertEquals(1, questionDAO.getQuestionList(questionVO.getTestNo()).size());		// ����~~~~~~~~~~~~~~~~~~~~~~~~~~ �ϴ� ����
	}
	
	@Test
	public void testCountQuestion(){
		assertEquals(1, questionDAO.countQuestion("N1"));
	}
}
