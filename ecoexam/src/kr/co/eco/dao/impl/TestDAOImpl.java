package kr.co.eco.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.eco.dao.TestDAO;
import kr.co.eco.vo.TestVO;

@Repository("testDAO")
public class TestDAOImpl implements TestDAO{
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public int addTest(TestVO testVO) {
		return (Integer) sqlMapClientTemplate.update("addTest", testVO);
	}

	public int deleteTest(TestVO testVO) {
		return (Integer) sqlMapClientTemplate.delete("deleteTest", testVO);
	}

	public List<TestVO> getTestList() {
		return (List<TestVO>) sqlMapClientTemplate.queryForList("getTestList");
	}
	
	public List<TestVO> getTestByTestName(String testName, String key) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("testName", testName);
		parameters.put("key", key);
		
		return (List<TestVO>) sqlMapClientTemplate.queryForList("getTestListByName", parameters);
	}

	public List<TestVO> getTestListByMaker(String testMakerID, String key) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("testMakerID", testMakerID);
		parameters.put("key", key);
		
		return (List<TestVO>) sqlMapClientTemplate.queryForList("getTestListByMaker", parameters);
	}

	public TestVO getTestByTestNo(String testNo) {
		return (TestVO) sqlMapClientTemplate.queryForObject("getTestByTestNo",testNo);
	}

	public int updateTest(TestVO testVO) {
		return (Integer) sqlMapClientTemplate.update("updateTest", testVO);
	}
	
	public List<TestVO> getTestListByKey(String key){
		return (List<TestVO>) sqlMapClientTemplate.queryForList("getTestListByKey", key);
	}
	
	public int addBaseTest(TestVO testVO) {
		return (Integer) sqlMapClientTemplate.update("addBaseTest", testVO);
	}
}
