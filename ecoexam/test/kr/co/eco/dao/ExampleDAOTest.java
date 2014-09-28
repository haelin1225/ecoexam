package kr.co.eco.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.co.eco.vo.CommentsVO;
import kr.co.eco.vo.CorrectAnswerVO;
import kr.co.eco.vo.ExampleVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class ExampleDAOTest {

	@Autowired
	ExampleDAO dao;
	
	@Test
	public void addExample() {
		ExampleVO example = new ExampleVO();
		example.setTestNo("N3");
		example.setQuestionNo(1);
		example.setExampleNo(1);
		example.setExampleContent("aaa");
		
		int count = dao.addExample(example);
		assertEquals(1, count);
	}
	
	@Test
	public void updateExample() {
		ExampleVO example = dao.getExample("N3", 1, 1);
		example.setExampleContent("bbb");
		
		int count = dao.updateExample(example);
		assertEquals(1, count);
	}
	
	@Test
	public void getExampleList(){
		System.out.println(dao.getExampleList("N9", 2));
	}

}
