package kr.co.eco.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.eco.dao.FaqDAO;
import kr.co.eco.vo.FaqVO;

@Repository("FaqDAO")
public class FaqDAOImpl implements FaqDAO {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	@Override
	public int addFaq(FaqVO faqVO) {
		return sqlMapClientTemplate.update("addFaq", faqVO);
	}

	@Override
	public int updateFaq(FaqVO faqVO) {
		return sqlMapClientTemplate.update("updateFaq", faqVO);
	}

	@Override
	public int updateFaqCount(FaqVO faqVO) {
		return sqlMapClientTemplate.update("updateFaqCount", faqVO);
	}

	@Override
	public int deleteFaq(int faqNo) {
		return sqlMapClientTemplate.delete("deleteFaq", faqNo);
	}

	@Override
	public FaqVO getFaq(int faqNo) {
		return (FaqVO)sqlMapClientTemplate.queryForObject("getFaq", faqNo);
	}

	@Override
	public List<FaqVO> getFaqList(int faqNo) {
		return sqlMapClientTemplate.queryForList("getFaqList", faqNo);
	}

	@Override
	public List<FaqVO> getFaqListByCategory(int faqNo, String category) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("faqNo", faqNo);
		parameters.put("category", category);
		return sqlMapClientTemplate.queryForList("getFaqListByCategory", parameters);
	}

}
