package kr.co.eco.dao.impl;

import java.util.HashMap;
import java.util.List;

import kr.co.eco.dao.GradeDAO;
import kr.co.eco.vo.GradeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository("gradeDAO")
public class GradeDAOImpl implements GradeDAO{

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public int addGrade(GradeVO gradeVO) {
		return sqlMapClientTemplate.update("insertGrade", gradeVO);
	}

	public GradeVO getGrade(int clubNo, String memberID, String testNo) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("clubNo", clubNo);
		parameters.put("memberID", memberID);
		parameters.put("testNo", testNo);
		return (GradeVO)sqlMapClientTemplate.queryForObject("getGrade", parameters);
	}

	public List<GradeVO> getGradeListByClub(int clubNo) {
		return null;
	}

	public List<GradeVO> getGradeListByMember(String memberID) {
		return null;
	}

	public List<GradeVO> getGradeListByTest(String testVo) {
		return null;
	}
	
}
