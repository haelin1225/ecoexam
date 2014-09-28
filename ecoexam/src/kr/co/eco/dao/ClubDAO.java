package kr.co.eco.dao;

import java.util.List;

import kr.co.eco.vo.ClubVO;

public interface ClubDAO {
	public int addClub(ClubVO clubVO);
	public int updateClub(ClubVO clubVO);
	public int deleteClub(int clubNo);
	public List<ClubVO> getClubList();
	public List<ClubVO> getClubListByClubName(String clubName);
	public int getClubCount();
	public int updateClubBoardNo(int clubNo, int boardNo);
	public ClubVO getClub(int clubNo);
	public List<String> getClubNameList();
}
