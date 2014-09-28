package kr.co.eco.service;

import java.util.List;

import kr.co.eco.vo.TestVO;

public interface TestService {

	public List<TestVO> getTest(String testName);
	public TestVO getTestByTestNo(String testNo);
	public List<TestVO> getTestListByKey(String key);
	public String addTest(TestVO test);
	public List<TestVO> getTestListByTestName(String testName, String key);
	public List<TestVO> getTestListByMaker(String testMakerID, String key);
	public String addBaseTest(TestVO test);

}
