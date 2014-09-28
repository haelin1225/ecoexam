package kr.co.eco.service;

import java.util.List;

import kr.co.eco.vo.ExampleVO;

public interface ExampleService {
	
	public int addExample(ExampleVO example);
	public int updateExample(ExampleVO exampleVO);
	public List<ExampleVO> getExampleList(String testNo, int questionNo);
	public int deleteExample(String testNo, int questionNo);
}
