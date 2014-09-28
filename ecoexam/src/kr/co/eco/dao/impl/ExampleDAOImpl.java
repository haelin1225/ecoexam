package kr.co.eco.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.eco.dao.ExampleDAO;
import kr.co.eco.vo.ExampleVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository("ExampleDAO")
public class ExampleDAOImpl implements ExampleDAO {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public int addExample(ExampleVO exampleVO) {
		return sqlMapClientTemplate.update("addExample", exampleVO);
	}

	public int updateExample(ExampleVO exampleVO) {
		return sqlMapClientTemplate.update("updateExample", exampleVO);
	}
	
	public ExampleVO getExample(String testNo, int questionNo, int exampleNo) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("testNo", testNo);
		parameters.put("questionNo", questionNo);
		parameters.put("exampleNo", exampleNo);
		return (ExampleVO)sqlMapClientTemplate.queryForObject("getExample", parameters);
	}

	public List<ExampleVO> getExampleList(String testNo, int questionNo) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("testNo", testNo);
		parameters.put("questionNo", questionNo);
		return sqlMapClientTemplate.queryForList("getExampleList", parameters);
	}
	public int deleteExample(String testNo, int questionNo){
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("testNo", testNo);
		parameters.put("questionNo", questionNo);
		return sqlMapClientTemplate.delete("deleteExample", parameters);
	}

}