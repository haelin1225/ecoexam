package kr.co.eco.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.eco.vo.ClubJoinVO;
import kr.co.eco.vo.ClubMemberVO;

public interface ClubJoinDAO {

	public int addClubMember(ClubJoinVO clubJoinVO);
	public int updateClubMemberByClubRole(ClubJoinVO clubJoinVO);
	public int updateClubMemberByClubAgreeOk(ClubJoinVO clubJoinVO);
	public int deleteClubMember(int clubNo, String memberID);
	public ClubJoinVO getClubMember(int clubNo, String memberID);
	public List<ClubJoinVO> getClubMemberList(int clubNo);
	public int addClubJoinManager(ClubJoinVO clubJoinVO);
	public List<ClubMemberVO> getClubJoinList(int clubNo);
	public int updateClubJoinAgreeOk(ClubJoinVO clubJoinVO);
}