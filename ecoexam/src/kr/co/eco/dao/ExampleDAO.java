package kr.co.eco.dao;

import java.util.List;

import kr.co.eco.vo.ExampleVO;

public interface ExampleDAO {
	public int addExample(ExampleVO exampleVO);
	public int updateExample(ExampleVO exampleVO);
	public ExampleVO getExample(String testNo, int questionNo, int exampleNo);
	public List<ExampleVO> getExampleList(String testNo, int questionNo);
	public int deleteExample(String testNo, int questionNo);
}