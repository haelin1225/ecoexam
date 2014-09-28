package kr.co.eco.dao;

import java.util.List;

import kr.co.eco.vo.FaqVO;

public interface FaqDAO {
	
	public int addFaq(FaqVO faqVO);
	public int updateFaq(FaqVO faqVO);
	public int updateFaqCount(FaqVO faqVO);
	public int deleteFaq(int faqNo);
	public FaqVO getFaq(int faqNo);
	public List<FaqVO> getFaqList(int faqNo);
	public List<FaqVO> getFaqListByCategory(int faqNo, String category);
	
}
