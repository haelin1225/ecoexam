package kr.co.eco.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.eco.dao.ClubDAO;
import kr.co.eco.dao.ClubJoinDAO;
import kr.co.eco.service.ClubService;
import kr.co.eco.vo.ClubJoinVO;
import kr.co.eco.vo.ClubMemberVO;
import kr.co.eco.vo.ClubVO;

@Service("clubService")
public class ClubServiceImpl implements ClubService {
	
	@Autowired
	ClubDAO clubDAO;
	@Autowired
	ClubJoinDAO clubJoinDAO;
	
	public List<ClubVO> getClubListByClubName(String clubName) {
		return clubDAO.getClubListByClubName(clubName);
	}
	public int addClub(ClubVO clubVO){
		clubDAO.addClub(clubVO);
		List<ClubVO> list = clubDAO.getClubListByClubName(clubVO.getClubName());
		int clubNo = list.get(list.size()-1).getClubNo();
		return clubNo;
	}
	public int updateClubBoardNo(int clubNo, int boardNo){
		return clubDAO.updateClubBoardNo(clubNo, boardNo); 
	}
	public ClubVO getClub(int clubNo){
		return clubDAO.getClub(clubNo);
	}
	public int addClubJoin(int clubNo, String memberID){
		ClubJoinVO clubJoinVO = new ClubJoinVO();
		clubJoinVO.setClubNo(clubNo);
		clubJoinVO.setMemberID(memberID);
		return clubJoinDAO.addClubMember(clubJoinVO);
	}
	public ClubJoinVO getClubJoin(int clubNo,String memberID){
		return clubJoinDAO.getClubMember(clubNo, memberID);
	}
	public int addClubJoinManager(int clubNo,String clubManagerID,String clubRole,String clubAgreeOk){
		ClubJoinVO clubJoinVO = new ClubJoinVO();
		clubJoinVO.setClubNo(clubNo);
		clubJoinVO.setMemberID(clubManagerID);
		clubJoinVO.setClubRole(clubRole);
		clubJoinVO.setClubAgreeOk(clubAgreeOk);
		return clubJoinDAO.addClubJoinManager(clubJoinVO);
	}
	public List<ClubMemberVO> getClubJoinList(int clubNo){
		return clubJoinDAO.getClubJoinList(clubNo);
	}
	public List<String> getClubNameList(){
		return clubDAO.getClubNameList();
	}
	public int updateClubJoinAgreeOk(int clubNo,String memberID,String clubAgreeOk){
		ClubJoinVO clubJoinVO = new ClubJoinVO();
		clubJoinVO.setClubNo(clubNo);
		clubJoinVO.setMemberID(memberID);
		clubJoinVO.setClubAgreeOk(clubAgreeOk);
		return clubJoinDAO.updateClubJoinAgreeOk(clubJoinVO);
	}
	public int deleteClubJoin(int clubNo, String memberID){
		return clubJoinDAO.deleteClubMember(clubNo, memberID);
	}
}
