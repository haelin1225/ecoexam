package kr.co.eco.service.impl;


import java.util.List;

import kr.co.eco.dao.TestDAO;

import kr.co.eco.dao.TestDAO;

import kr.co.eco.service.TestService;
import kr.co.eco.vo.TestVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("testService")
public class TestServiceImpl implements TestService{

	@Autowired
	private TestDAO testDAO;
	
	@Override
	public List<TestVO> getTest(String testName) {
//		List<TestVO> list = null;
//		System.out.println("TestServiceImpl");
//		list = testDAO.getTestByTestName(testName);
//		System.out.println("search결과" + list);
//		return list;
//		return testDAO.getTestByTestName(testName);
		return null;
	}


	public TestVO getTestByTestNo(String testNo){
		return testDAO.getTestByTestNo(testNo);

	}
	public List<TestVO> getTestListByKey(String key){
		System.out.println("넘겨 받은 key 값 : " + key);
		return testDAO.getTestListByKey(key);
	}
	
	
	public List<TestVO> getTestListByTestName(String testName, String key){
		return testDAO.getTestByTestName(testName, key);
	}
	
	public List<TestVO> getTestListByMaker(String testMakerID, String key){
		return testDAO.getTestListByMaker(testMakerID, key);
	}

	// 제작문제 추가
	public String addTest(TestVO test) {
		int count = testDAO.addTest(test);
		List<TestVO> list = testDAO.getTestByTestName(test.getTestName(), "N");
		String testNo = list.get(list.size()-1).getTestNo();
		System.out.println("Service:"+testNo);
		return testNo;
	}

	public String addBaseTest(TestVO test) {
		int count = testDAO.addBaseTest(test);
		System.out.println(count);
		List<TestVO> list = testDAO.getTestByTestName(test.getTestName(), "E");
		String testNo = list.get(list.size()-1).getTestNo();
		return testNo;
	}
}
