package kr.co.eco.dao;

import java.util.List;

import kr.co.eco.vo.PostVO;
import kr.co.eco.vo.TestVO;

public interface TestDAO {
	public int addTest(TestVO testVO);
	public int deleteTest(TestVO testVO);
	public List<TestVO> getTestList();
	public List<TestVO> getTestListByMaker(String testMakerID, String key);
	public List<TestVO> getTestByTestName(String testName, String key);
	public List<TestVO> getTestListByKey(String key);
	public TestVO getTestByTestNo(String testNo);
	public int updateTest(TestVO testVO);
	public int addBaseTest(TestVO testVO);
}
