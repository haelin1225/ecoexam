package kr.co.eco.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.eco.dao.ClubJoinDAO;
import kr.co.eco.vo.ClubJoinVO;
import kr.co.eco.vo.ClubMemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository("ClubJoinDAO")
public class ClubJoinDAOImpl implements ClubJoinDAO{
	
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	public int addClubMember(ClubJoinVO clubJoinVO) {
		return sqlMapClientTemplate.update("addClubMember", clubJoinVO);
	}

	public int updateClubMemberByClubRole(ClubJoinVO clubJoinVO) {
		return sqlMapClientTemplate.update("updateClubMemberByClubRole", clubJoinVO);
	}

	public int updateClubMemberByClubAgreeOk(ClubJoinVO clubJoinVO) {
		return sqlMapClientTemplate.update("updateClubMemberByClubAgreeOk", clubJoinVO);
	}

	public int deleteClubMember(int clubNo, String memberID) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("clubNo", clubNo);
		parameters.put("memberID", memberID);
		
		return sqlMapClientTemplate.delete("deleteClubMember", parameters);
	}

	public ClubJoinVO getClubMember(int clubNo, String memberID) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("clubNo", clubNo);
		parameters.put("memberID", memberID);
		
		return (ClubJoinVO)sqlMapClientTemplate.queryForObject("getClubMember", parameters);
	}

	public List<ClubJoinVO> getClubMemberList(int clubNo) {
		return (List<ClubJoinVO>)sqlMapClientTemplate.queryForList("getClubMemberList", clubNo);
	}
	public int addClubJoinManager(ClubJoinVO clubJoinVO){
		return sqlMapClientTemplate.update("addClubJoinManager", clubJoinVO);
	}
	public List<ClubMemberVO> getClubJoinList(int clubNo){
		return sqlMapClientTemplate.queryForList("getClubJoinList", clubNo);
	}
	public int updateClubJoinAgreeOk(ClubJoinVO clubJoinVO){
		return sqlMapClientTemplate.update("updateClubMemberByClubAgreeOk", clubJoinVO);
	}
}