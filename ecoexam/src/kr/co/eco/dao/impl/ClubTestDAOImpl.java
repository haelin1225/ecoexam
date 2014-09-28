package kr.co.eco.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.eco.dao.ClubTestDAO;
import kr.co.eco.vo.ClubTestVO;
@Repository("clubTestDAO")
public class ClubTestDAOImpl implements ClubTestDAO{
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public List<ClubTestVO> getClubTestByTestNo(String testNo) {
		return (List<ClubTestVO>) sqlMapClientTemplate.queryForList("getClubTestByTestNo",testNo);
	}

	public List<ClubTestVO> getClubTestByClubNo(int clubNo) {
		return (List<ClubTestVO>) sqlMapClientTemplate.queryForList("getClubTestByClubNo",clubNo);
	}

	public int addClubTest(ClubTestVO clubTestVO) {
		return (Integer) sqlMapClientTemplate.update("addClubTest", clubTestVO);
	}

	public int deleteClubTest(ClubTestVO clubTestVO) {
		return (Integer) sqlMapClientTemplate.delete("deleteClubTest", clubTestVO);
	}
	
}
