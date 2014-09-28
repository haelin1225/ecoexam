package kr.co.eco.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.co.eco.vo.PostVO;
import kr.co.eco.vo.TestVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class TestDAOTest {
	@Autowired
	TestDAO testDAO;
	
	@Test
	public void testGetTestList() {
		List<TestVO> list = testDAO.getTestList();
		for(TestVO ct : list) {
			System.out.println(ct);
		}
	}
	
	@Test
	public void testGetTestListByMaker() {
//		List<TestVO> list = testDAO.getTestListByMaker("M2");
//		for(TestVO ct : list) {
//			System.out.println(ct);
//		}
	}
	@Test
	public void testGetTestListByKey() {
		List<TestVO> list = testDAO.getTestListByKey("N");
		for(TestVO ct : list) {
			System.out.println(ct);
		}
	}
	@Test
	public void testGetTestListByTestNo() {
		System.out.println(testDAO.getTestByTestNo("N2"));
	}
	
	@Test
	public void testAddTest(){
		TestVO testVO = new TestVO();
		testVO.setTestMakerID("M2");
		testVO.setTestName("junit!!!");
		testVO.setTestTime(100);
		testVO.setTestTotalScore(100);
		testVO.setTestPoint("true");
		testVO.setTestKind("林包侥");
		testVO.setTestExampleCount(0);
		testVO.setTestTotalQuestion(10);
		assertNotNull(testDAO.addTest(testVO));
	}
	
	@Test
	public void testDeleteTest(){
		TestVO testVO = new TestVO();
		testVO.setTestMakerID("M1");
		testVO.setTestNo("N4");
		assertNotNull(testDAO.deleteTest(testVO));
	}
	
	@Test
	public void testUpdateTest(){
		TestVO testVO = new TestVO();
		testVO.setTestNo("N2");
		testVO.setTestMakerID("M1");
		testVO.setTestName("no2");
		testVO.setTestTime(200);
		testVO.setTestTotalScore(200);
		testVO.setTestPoint("true");
		testVO.setTestKind("林包侥");
		testVO.setTestExampleCount(0);
		testVO.setTestTotalQuestion(10);
		assertNotNull(testDAO.updateTest(testVO));
	}
}
