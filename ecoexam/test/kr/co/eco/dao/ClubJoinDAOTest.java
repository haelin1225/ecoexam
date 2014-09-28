package kr.co.eco.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.co.eco.vo.ClubJoinVO;
import kr.co.eco.vo.CommentsVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class ClubJoinDAOTest {

	@Autowired
	ClubJoinDAO dao;
	
	@Test
	public void addClubMember() {
		ClubJoinVO clubJoin = new ClubJoinVO();
		clubJoin.setClubNo(2);
		clubJoin.setMemberID("user01");

		int count = dao.addClubMember(clubJoin);
		assertEquals(1, count);
	}
	
	
	@Test
	public void updateClubMemberByClubRole() {
		ClubJoinVO clubJoin = dao.getClubMember(2, "user01");
		clubJoin.setClubRole("manager");
		
		int count = dao.updateClubMemberByClubRole(clubJoin);
		assertEquals(1, count);
	}
	
	@Test
	public void updateClubMemberByClubAgreeOk() {
		ClubJoinVO clubJoin = dao.getClubMember(2, "user01");
		clubJoin.setClubAgreeOk("true");
		
		int count = dao.updateClubMemberByClubAgreeOk(clubJoin);
		assertEquals(1, count);
	}
	
	
	@Test
	public void deleteClubMember() {
		int count = dao.deleteClubMember(2, "user01");
		assertEquals(1, count);
	}
	
	@Test
	public void getClubMemberList() {
		List<ClubJoinVO> list = dao.getClubMemberList(2);
		assertEquals(1, list.size());
		
		for(ClubJoinVO clubMember : list) {
			System.out.println(clubMember);
		}
	}
}
