package kr.co.eco.service;

import java.util.List;

import kr.co.eco.vo.ClubJoinVO;
import kr.co.eco.vo.ClubMemberVO;
import kr.co.eco.vo.ClubVO;

public interface ClubService {
	
	public List<ClubVO> getClubListByClubName(String clubName);
	public int addClub(ClubVO clubVO);
	public int updateClubBoardNo(int clubNo, int boardNo);
	public ClubVO getClub(int clubNo);
	public int addClubJoin(int clubNo, String memberID);
	public ClubJoinVO getClubJoin(int clubNo,String memberID);
	public int addClubJoinManager(int clubNo,String clubManagerID,String clubRole,String clubAgreeOk);
	public List<ClubMemberVO> getClubJoinList(int clubNo);
	public List<String> getClubNameList();
	public int updateClubJoinAgreeOk(int clubNo,String memberID,String clubAgreeOk);
	public int deleteClubJoin(int clubNo, String memberID);
}
