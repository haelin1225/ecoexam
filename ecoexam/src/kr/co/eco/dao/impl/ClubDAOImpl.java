package kr.co.eco.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.eco.dao.ClubDAO;
import kr.co.eco.vo.ClubVO;

@Repository("clubDAO")
public class ClubDAOImpl implements ClubDAO {
	
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	private ClubVO clubVO;
	
	public int addClub(ClubVO clubVO) {
		return sqlMapClientTemplate.update("insertClub", clubVO); 
	}

	public int updateClub(ClubVO clubVO) {
		return sqlMapClientTemplate.update("updateClub", clubVO);				
	}

	public int deleteClub(int clubNo) {
		return sqlMapClientTemplate.delete("deleteClub", clubNo);
	}

	public List<ClubVO> getClubList() {
		return sqlMapClientTemplate.queryForList("clubList");
	}
	
	public List<ClubVO> getClubListByClubName(String clubName) {
		return sqlMapClientTemplate.queryForList("getClubListByClubName", clubName);
	}

	public int getClubCount() {
		return 0;
	}
	public ClubVO getClub(int clubNo) {
		return (ClubVO)sqlMapClientTemplate.queryForObject("getClub", clubNo);
	}
	public int updateClubBoardNo(int clubNo, int boardNo){
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("clubNo", clubNo);
		parameters.put("boardNo", boardNo);
		return sqlMapClientTemplate.update("updateClubBoardNo", parameters);
	}
	public List<String> getClubNameList(){
		return sqlMapClientTemplate.queryForList("getClubNameList");
	}
	
	
}
