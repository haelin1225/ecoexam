package kr.co.eco.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.eco.dao.ExampleDAO;
import kr.co.eco.service.ExampleService;
import kr.co.eco.vo.ExampleVO;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{
	@Autowired
	private ExampleDAO exampleDAO;
	
	public int addExample(ExampleVO example) {
		int add = 0;
		try{
			add = exampleDAO.addExample(example);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return add;
		}		
	}
	public int updateExample(ExampleVO exampleVO){
		int upd = 0;
		try{
			upd = exampleDAO.updateExample(exampleVO);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return upd;
		}
	}
	public List<ExampleVO> getExampleList(String testNo, int questionNo){
		return exampleDAO.getExampleList(testNo, questionNo);
	}
	public int deleteExample(String testNo, int questionNo){
		return exampleDAO.deleteExample(testNo, questionNo);
	}
}
